package com.torutk.book.chapter5;

import com.torutk.book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/torutk/chapter5/greeting-post"})
public class GreetingPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        req.setCharacterEncoding("UTF-8");
        var user = req.getParameter("user");

        Page.header(out);
        out.printf("<p>こんにちは、%sさん！</p>%n", user);
        Page.footer(out);
    }
}
