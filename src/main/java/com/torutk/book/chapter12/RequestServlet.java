package com.torutk.book.chapter12;

import com.torutk.book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/torutk/chapter12/request"})
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        out.println("""
                <p>Request URL<br>%s</p>
                <p>Host<br>%s</p>
                <p>User-Agent<br>%s</p>
                <p>Remote-Address<br>%s</p>
                """.formatted(
                        req.getRequestURL(), req.getHeader("Host"), req.getHeader("User-Agent"), req.getRemoteAddr()
                )
        );
        Page.footer(out);
    }
}
