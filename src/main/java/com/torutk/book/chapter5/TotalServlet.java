package com.torutk.book.chapter5;

import com.torutk.book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/torutk/chapter5/total"})
public class TotalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Page.header(out);
        req.setCharacterEncoding("UTF-8");

        try {
            var price = Integer.parseInt(req.getParameter("price"));
            var count = Integer.parseInt(req.getParameter("count"));
            out.println("""
                    %d円 × %d個 = %d 円
                    """.formatted(price, count, price * count)
            );
        } catch (NumberFormatException e) {
            out.println("数値を入力してください。");
        } finally {
            Page.footer(out);
        }
    }
}
