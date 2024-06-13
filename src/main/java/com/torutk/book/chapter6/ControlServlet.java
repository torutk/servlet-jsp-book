package com.torutk.book.chapter6;

import com.torutk.book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@WebServlet(urlPatterns = {"/torutk/chapter6/control"})
public class ControlServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Page.header(out);

        req.setCharacterEncoding("UTF-8");
        StreamSupport.stream(Spliterators.spliteratorUnknownSize(req.getParameterNames().asIterator(), Spliterator.ORDERED),false)
                .flatMap(name -> Stream.of(req.getParameterValues(name))
                        .map(value -> "<p>" + name + "=" + value + "</p>"))
                .forEach(out::println);
        Page.footer(out);
    }
}
