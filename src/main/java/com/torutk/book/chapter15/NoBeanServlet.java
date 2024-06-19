package com.torutk.book.chapter15;

import com.torutk.book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/torutk/chapter15/nobean"})
public class NoBeanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        int id = 1;
        String name = "まぐろ";
        int price = 100;

        out.printf("%d：%s：%d%n", id, name, price);

        Page.footer(out);
    }
}
