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
import java.util.concurrent.TimeUnit;

@WebServlet(urlPatterns = {"/chapter14/bigdatainsert4"})
public class BigdataInsert4 extends HttpServlet {
    private static final int NUM_PER_BATCH = 1000;
    private static final int NUM_BATCHES = (int) (3_000_000_000L / NUM_PER_BATCH);

    private void batchInsert(Connection conn, long offset) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("insert into bigdata(name) values(?)")) {
            for (int i = 0; i < NUM_PER_BATCH; i++) {
                st.setString(1, String.format("010%d", offset + i));
                st.addBatch();
            }
            st.executeBatch();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/book");
            try (Connection conn = ds.getConnection()) {
                conn.setAutoCommit(false);
                System.out.println("Total transactions: " + NUM_BATCHES);
                long previousTime = System.nanoTime();
                for (int i = 0; i < NUM_BATCHES; i++) {
                    batchInsert(conn, (long) i * NUM_PER_BATCH);
                    if (i % 1_000 == 0) {
                        conn.commit();
                        long now = System.nanoTime();
                        System.out.printf("%d(%d sec), ", i / 1_000, TimeUnit.NANOSECONDS.toSeconds(now - previousTime));
                        previousTime = now;
                    }
                }
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
