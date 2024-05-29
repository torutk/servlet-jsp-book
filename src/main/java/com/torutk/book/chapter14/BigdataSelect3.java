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

@WebServlet(urlPatterns = {"/chapter14/bigdataselect3"})
public class BigdataSelect3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        try {
            var nameContext = new InitialContext();
            DataSource ds = (DataSource) nameContext.lookup("java:comp/env/jdbc/book");
            try (Connection conn = ds.getConnection();
                 PreparedStatement ps = conn.prepareStatement("select * from bigdata where name like ?")
            ) {
                ps.setString(1, "%" + req.getParameter("name") + "%");
                try (ResultSet rs = ps.executeQuery()) {
                    out.println("""
                            <table>
                            <thead>
                              <tr><th>ID</th><th>Name</th></tr>
                            </thead>
                            <tbody>""");
                    while (rs.next()) {
                        out.println("""
                                <tr><td>%d</td><td>%s</td></tr>
                                """.formatted(rs.getLong(1), rs.getString(2))
                        );
                    }
                    out.println("</tbody></table>");
                }
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace(out);
        } finally {
            Page.footer(out);
        }
    }
}
