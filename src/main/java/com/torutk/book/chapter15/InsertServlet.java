package com.torutk.book.chapter15;

import com.torutk.book.bean.Product;
import com.torutk.book.dao.ProductDao;
import com.torutk.book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/torutk/chapter15/insert"})
public class InsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        try {
            String name = req.getParameter("name");
            int price = Integer.parseInt(req.getParameter("price"));

            Product product = new Product(name, price);
            ProductDao dao = new ProductDao();
            int result = dao.insert(product);

            if (result > 0) {
                out.println("追加に成功しました。");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
