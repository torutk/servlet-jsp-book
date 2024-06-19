package com.torutk.book.chapter15;

import com.torutk.book.bean.Product;
import com.torutk.book.dao.ProductDao;
import com.torutk.book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.NamingException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/torutk/chapter15/search"})
public class SearchServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        String keyword = req.getParameter("keyword");
        ProductDao dao = new ProductDao();
        try {
            List<Product> products = dao.search(keyword);
            for (Product product : products) {
                out.printf("%d：%s：%d<br>%n", product.id(), product.name(), product.price());
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }

}
