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

@WebServlet(urlPatterns = {"/torutk/chapter14/transaction"})
public class TransactionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));

        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/book");
            try (Connection conn = ds.getConnection()) {
                conn.setAutoCommit(false);
                try (
                        PreparedStatement updateStatement = conn.prepareStatement("insert into product(name, price) values(?, ?)");
                        PreparedStatement selectStatement = conn.prepareStatement("select * from product where name = ?")
                ) {
                    updateStatement.setString(1, name);
                    updateStatement.setInt(2, price);
                    updateStatement.executeUpdate();

                    selectStatement.setString(1, name);
                    try (ResultSet rs = selectStatement.executeQuery()) {
                        rs.last();
                        int rows = rs.getRow();
                        if (rows == 1) {
                            conn.commit();
                            out.println("商品を登録しました。");
                        } else {
                            conn.rollback();
                            out.println("商品は既に登録されています。");
                        }
                    }
                }
                conn.setAutoCommit(true);
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
