package com.torutk.book.tool;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = {
        "/torutk/chapter10/*", "/torutk/chapter11/*", "/torutk/chapter12/*", "/torutk/chapter13/*", "/torutk/chapter14/*",
        "/torutk/chapter15/*", "/torutk/chapter16/*", "/torutk/chapter17/*", "/torutk/chapter18/*", "/torutk/chapter19/*",
        "/torutk/chapter20/*", "/torutk/chapter21/*", "/torutk/chapter22/*", "/torutk/chapter23/*", "/torutk/chapter24/*",
        "/torutk/chapter25/*"
}, asyncSupported = true)
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("フィルタの前処理");
        chain.doFilter(request, response);
        System.out.println("フィルタの後処理");
    }
}
