package com.torutk.book.chapter14;

import book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.stream.Stream;

@WebServlet(urlPatterns = {"/chapter14/bigdatainsert5"})
public class BigdataInsert5 extends HttpServlet {
    private static final long TOTAL_ROWS = 3_000_000_000L;


    private String createInsertQuery(int numRows) {
        var sb = new StringBuilder();
        sb.append("insert into bigdata(name) values ");
        sb.append(String.join(", ", Stream.generate(() -> "(?)").limit(numRows).toList()));
        return sb.toString();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/book");
            int rowsPerInsert = Integer.parseInt(req.getParameter("rows"));
            boolean isAutoCommit = Boolean.parseBoolean(req.getParameter("autocommit"));
            try (
                    Connection conn = ds.getConnection();
                    PreparedStatement st = conn.prepareStatement(createInsertQuery(rowsPerInsert));
            ) {
                System.out.println("Total rows: " + TOTAL_ROWS + ", rows per insert: " + rowsPerInsert + ", with auto commit: " + isAutoCommit);
                if (!isAutoCommit) {
                    conn.setAutoCommit(false);
                }
                long num_inserts = TOTAL_ROWS / rowsPerInsert;
                long previousTime = System.nanoTime();
                for (long i = 0; i <num_inserts ; i++) {
                    for (int j = 1; j <= rowsPerInsert; j++) {
                        st.setString(j, String.format("%010d", i * num_inserts + j));
                    }
                    st.executeUpdate();
                    int count_10million = 10_000_000 / rowsPerInsert;
                    if (i % count_10million == 0) {
                        if (!isAutoCommit) {
                            conn.commit();
                        }
                        long now = System.nanoTime();
                        System.out.printf("%d(%d sec), ", i / count_10million, (now - previousTime) / 1_000_000_000);
                        previousTime = now;
                    }
                }
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace(out);
        } catch (Exception e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
