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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/chapter14/bigdataselect"})
public class BigdataSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        try {
            var nameContext = new InitialContext();
            DataSource ds = (DataSource) nameContext.lookup("java:comp/env/jdbc/book");
            try (Connection conn = ds.getConnection();
                 PreparedStatement ps = conn.prepareStatement("select count(*) from bigdata")
            ) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    out.println("""
                            <p> Bigdata table has %d rows
                            """.formatted(rs.getLong(1)))
                    ;
                }
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace(out);
        } finally {
            Page.footer(out);
        }
    }
}
