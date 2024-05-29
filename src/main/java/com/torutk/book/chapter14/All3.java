package com.torutk.book.chapter14;

import com.torutk.book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(urlPatterns = {"/chapter/14/all3"})
public class All3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/book");
            System.out.println(ds.getClass().getName());
            try (Connection conn = ds.getConnection()) {
                try (PreparedStatement ps = conn.prepareStatement("select * from product")) {
                    try (ResultSet rs = ps.executeQuery()) {
                        while (rs.next()) {
                            out.println(rs.getInt("id"));
                            out.println(":");
                            out.println(rs.getString("name"));
                            out.println(":");
                            out.println(rs.getInt("price"));
                            out.println("<br>");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
