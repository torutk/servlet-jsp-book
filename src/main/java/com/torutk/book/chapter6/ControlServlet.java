package com.torutk.book.chapter6;

import com.torutk.book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.stream.Stream;

@WebServlet(urlPatterns = {"/torutk/chapter6/control"})
public class ControlServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Page.header(out);

        req.setCharacterEncoding("UTF-8");
        Collections.list(req.getParameterNames()).stream()
                .flatMap(name -> Stream.of(req.getParameterValues(name))
                        .map(value -> "<p>" + name + "=" + value + "</p>"))
                .forEach(out::println);
        Page.footer(out);
    }
}
