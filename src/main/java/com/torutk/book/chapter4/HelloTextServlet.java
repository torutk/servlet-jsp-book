package com.torutk.book.chapter4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/torutk/chapter4/hello-text"})
public class HelloTextServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest req, HttpServletResponse resp
    ) throws ServletException, IOException {

        resp.setContentType("text/plain; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("Hello!");
        out.println("こんにちは！");
        out.println(java.time.ZonedDateTime.now());
    }
}
