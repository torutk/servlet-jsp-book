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

@WebServlet(urlPatterns = {"/chapter14/bigdatainsert3"})
public class BigdataInsert3 extends HttpServlet {
    private static final int NUM_PER_BATCH = 1000;
    private static final int NUM_BATCHES = (int) (3_000_000_000L / NUM_PER_BATCH);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/book");
            try (
                    Connection conn = ds.getConnection();
                    PreparedStatement st = conn.prepareStatement("insert into bigdata(name) values(?)")
            ) {
                conn.setAutoCommit(false);
                System.out.println("Total transactions: " + NUM_BATCHES);
                long previousTime = System.nanoTime();
                for (int i = 0; i < NUM_BATCHES; i++) {
                    for (int j = 0; j < NUM_PER_BATCH; j++) {
                        st.setString(1, String.format("%010d", i * NUM_BATCHES + j));
                        st.addBatch();
                    }
                    st.executeUpdate();
                    conn.commit();
                    if (i % 1_000 == 0) {
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
