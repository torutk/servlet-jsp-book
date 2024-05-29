package com.torutk.book;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZonedDateTime;

public class HelloXray extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        var out = resp.getWriter();
        out.println("""
                <!DOCTYPE html>
                <html>
                <head>
                <meta charset="UTF-8">
                <title>Hello Servlet/JSP</title>
                </head>
                <body>
                <p>Hello Servlet/JSP</p>
                <p>こんにちは、サーブレット／JSP</p>
                <p>%s</p>
                </body>
                </html>""".formatted(ZonedDateTime.now()));
    }
}
