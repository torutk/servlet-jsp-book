package com.torutk.book.chapter10;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();

        out.println("[HelloFilter(pre)]");
        filterChain.doFilter(servletRequest, servletResponse);
        out.println("[HelloFilter(post)]");
    }
}
