package com.torutk.book.chapter4;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloHtmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("""
                <!DOCTYPE html>
                <html lang="ja">
                <head>
                <meta charset="UTF-8">
                <title>Servlet/JSP Sample Programs Refined</title>
                </head>
                <body>
                <p>Hello!</p>
                <p>こんにちは！</p>
                <p>%s</p>
                </body>
                </html>
                """.formatted(java.time.ZonedDateTime.now())
        );
    }
}
