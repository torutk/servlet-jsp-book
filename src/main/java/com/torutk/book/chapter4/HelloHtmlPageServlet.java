package com.torutk.book.chapter4;

import com.torutk.book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/torutk/chapter4/hello-html-page"})
public class HelloHtmlPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Page.header(out);

        out.println("""
                <p>Hello!</p>
                <p>こんにちは！</p>
                <p>%s</p>
                """.formatted(java.time.ZonedDateTime.now())
        );

        Page.footer(out);
    }
}
