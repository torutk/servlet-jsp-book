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

@WebServlet(urlPatterns = {"/chapter14/bigdatainsert"})
public class BigdataInsert extends HttpServlet {
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
                var baseTime = System.nanoTime();
                for (long li = 0; li < 3_000_000_000L; li++) {
                    st.setString(1, String.format("%010d", li));
                    st.executeUpdate();

                    var nowTime = System.nanoTime();
                    if (nowTime - baseTime > 60_000_000_000L) {
                        System.out.printf("%d, ", li);
                        baseTime = nowTime;
                    } else if (li % 50_000_000 == 0) {
                        System.out.printf("%d, ", li);
                    }
                }
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
