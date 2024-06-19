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
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/torutk/chapter14/insert"})
public class InsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/book");

            String name = req.getParameter("name");
            int price = Integer.parseInt(req.getParameter("price"));

            try (
                    Connection conn = ds.getConnection();
                    PreparedStatement ps = conn.prepareStatement("insert into product(name, price) values(?, ?)")
            ) {
                ps.setString(1, name);
                ps.setInt(2, price);
                int line = ps.executeUpdate();

                if (line > 0) {
                    out.println("追加に成功しました。");
                }
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
