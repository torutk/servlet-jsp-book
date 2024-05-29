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

@WebServlet(urlPatterns = {"/chapter14/bigdatainsert2"})
public class BigdataInsert2 extends HttpServlet {
    private static final int NUM_PER_TRANSACTION = 1_000_000;
    private static final int NUM_TRANSACTIONS = (int) (3_000_000_000L / NUM_PER_TRANSACTION);

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
                System.out.println("Total transactions: " + NUM_TRANSACTIONS);
                for (int i = 0; i < NUM_TRANSACTIONS; i++) {
                    for (int j = 0; j < NUM_PER_TRANSACTION; j++) {
                        st.setString(1, String.format("%010d", i * NUM_TRANSACTIONS + j));
                        st.executeUpdate();
                    }
                    conn.commit();
                    System.out.printf("%d, ", i);
                }
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
