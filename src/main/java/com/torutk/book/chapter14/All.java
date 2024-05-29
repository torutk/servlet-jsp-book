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

@WebServlet(urlPatterns = {"/chapter/14/all"})
public class All extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        InitialContext ic = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/book");
            System.out.println(ds.getClass().getName());
            conn = ds.getConnection();
            ps = conn.prepareStatement("select * from product");
            rs = ps.executeQuery();

            while (rs.next()) {
                out.println(rs.getInt("id"));
                out.println(":");
                out.println(rs.getString("name"));
                out.println(":");
                out.println(rs.getInt("price"));
                out.println("<br>");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        } finally {
            try {
                rs.close();
            } catch (Exception ignored) {}
            try {
                ps.close();
            } catch (Exception ignored) {}
            try {
                conn.close();
            } catch (Exception ignored) {}
            try {
                ic.close();
            } catch (Exception ignored) {}
        }

    }
}
