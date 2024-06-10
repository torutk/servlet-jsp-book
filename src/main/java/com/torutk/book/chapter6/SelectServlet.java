package com.torutk.book.chapter6;

import com.torutk.book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/torutk/chapter6/select"})
public class SelectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        req.setCharacterEncoding("UTF-8");
        var count = req.getParameter("count");
        var payment = req.getParameter("payment");
        var review = req.getParameter("review");
        var mail = req.getParameter("mail");

        Page.header(out);
        out.println("""
                <p>%s個の商品をカートに入れました。</p>
                <p>お支払方法を%sに設定しました。</p>
                <p>ご感想ありがとうございます。</p>
                <p>「%s」</p>
                <p>%s</p>
                """.formatted(count, payment, review, mail == null ? "メールはお送りしません。" : "メールをお送りします。")
        );
        Page.footer(out);
    }
}
