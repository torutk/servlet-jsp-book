package com.torutk.book.chapter11;

import com.torutk.book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet(urlPatterns = {"/torutk/chapter11/count-thread"})
public class CountThreadServlet extends HttpServlet {
    int count;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        int i = count;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            // do nothing
        }
        count = i + 1;
        out.println(count);
        Page.footer(out);
    }
}
