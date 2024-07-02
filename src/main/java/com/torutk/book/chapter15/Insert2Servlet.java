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

@WebServlet(urlPatterns = {"/torutk/chapter15/insert2"})
public class Insert2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        String name = req.getParameter("name");;
        int price = Integer.parseInt(req.getParameter("price"));

        Product product = new Product(name, price);
        ProductDao dao = new ProductDao();
        try {
            dao.insert(product);
            List<Product> products = dao.search("");
            for (Product p : products) {
                out.printf("%d：%s：%d<br>%n", p.id(), p.name(), p.price());
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
