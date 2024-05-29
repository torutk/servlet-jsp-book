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

@WebServlet(urlPatterns = {"/chapter14/bigdataselect2"})
public class BigdataSelect2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        long id = Long.parseLong(req.getParameter("id"));
        try {
            var nameContext = new InitialContext();
            DataSource ds = (DataSource) nameContext.lookup("java:comp/env/jdbc/book");
            try (Connection conn = ds.getConnection();
                 PreparedStatement ps = conn.prepareStatement("select * from bigdata where id = ?")
            ) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        out.println("""
                                <table>
                                <thead>
                                <tr><th>ID</th><th>Name</th></tr>
                                </thead>
                                <tbody>
                                <tr><td>%d</td><td>%s</td></tr>
                                </tbody>
                                </table>
                                """.formatted(
                                        rs.getLong(1), rs.getString(2))
                        );
                    }
                }
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace(out);
        } finally {
            Page.footer(out);
        }
    }
}
