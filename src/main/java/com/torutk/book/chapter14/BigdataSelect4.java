package com.torutk.book.chapter14;

import book.tool.Page;
import jakarta.servlet.AsyncContext;
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

/**
 * Bigdataテーブルから指定した文字列を含むnameのレコードを検索する。
 * <p>非同期で実行</p>
 */
@WebServlet(urlPatterns = {"/chapter14/bigdataselect4"}, asyncSupported = true)
public class BigdataSelect4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String word = req.getParameter("name");
        Page.header(out);
        out.println("<h1>" + word + "の検索を非同期で実行</h1>");
        out.flush();
        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(() -> search(asyncContext, word));
        Page.footer(out);
    }

    private void search(AsyncContext asyncContext, String word) {
        HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
        try {
            PrintWriter out = response.getWriter();
            var nameContext = new InitialContext();
            DataSource ds = (DataSource) nameContext.lookup("java:comp/env/jdbc/book");
            try (Connection conn = ds.getConnection();
                 PreparedStatement ps = conn.prepareStatement("select * from bigdata where name like ?")
            ) {
                ps.setString(1, "%" + word + "%");
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
                asyncContext.complete();
            }
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }

    }
}
