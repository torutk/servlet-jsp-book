package com.torutk.book.chapter14;

import com.torutk.book.tool.Page;
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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/torutk/chapter14/search"})
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/book");
            String keyword = req.getParameter("keyword");
            try (
                    Connection conn = ds.getConnection();
                    PreparedStatement ps = conn.prepareStatement("select * from product where name like ?")
            ) {
                ps.setString(1, "%" + keyword + "%");
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        out.printf("%d:%s:%d<br>%n",
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("price")
                        );
                    }
                }
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
