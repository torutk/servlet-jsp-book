package com.torutk.book.chapter15;

import com.torutk.book.bean.Product;
import com.torutk.book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/torutk/chapter15/bean"})
public class BeanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        Product product = new Product(1, "まぐろ", 100);

        out.printf("%d：%s：%d%n", product.id(), product.name(), product.price());

        Page.footer(out);
    }
}
