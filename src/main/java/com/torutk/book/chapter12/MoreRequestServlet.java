package com.torutk.book.chapter12;

import com.torutk.book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/torutk/chapter12/more-request"})
public class MoreRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        out.println("""
                <p>Method<br>%s</p>
                <p>Request URI<br>%s</p>
                <p>Context Path<br>%s</p>
                <p>Servlet Path<br>%s</p>
                <p>Query String<br>%s</p>
                <p>Protocol<br>%s</p>
                <p>Request URL<br>%s</p>
                <p>Scheme<br>%s</p>
                <p>Server Name<br>%s</p>
                <p>Server Port<br>%s</p>
                """.formatted(
                        req.getMethod(), req.getRequestURI(), req.getContextPath(),
                        req.getServletPath(), req.getQueryString(), req.getProtocol(),
                        req.getRequestURL(), req.getScheme(), req.getServerName(), req.getServerPort()
                )
        );
        Page.footer(out);
    }
}
