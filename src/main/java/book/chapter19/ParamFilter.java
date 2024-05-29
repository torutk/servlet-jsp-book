package book.chapter19;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ParamFilter implements Filter {
    private String message;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        message = filterConfig.getInitParameter("message");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        out.println(message);
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
