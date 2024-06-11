package com.torutk.book.chapter6;

import book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/torutk/chapter6/checkbox"})
public class CheckboxServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        req.setCharacterEncoding("UTF-8");
        String[] genres = req.getParameterValues("genre");

        Page.header(out);
        if (genres != null) {
            for (String genre : genres) {
                out.println("「" + genre + "」");
            }
            out.println("に関するお買い得情報をお送りします。");
        } else {
            out.println("お買い得情報はお送りしません。");
        }
        Page.footer(out);
    }
}
