package book.tool;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = {"/*"})
@WebFilter(urlPatterns = {"" +
        "/chapter10/*", "/chapter11/*", "/cahpter12/*", "/chapter14/*", "/chapter15/*", "/chapter16/*", "/chapter17/*",
        "/chapter18/*", "/chapter19/*", "/chapter20/*", "/chapter21/*", "/chapter22/*", "/chapter23/*", "/chapter24/*",
        "/chapter25/*"
})
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.println("フィルタの前処理");

        chain.doFilter(request, response);

        System.out.println("フィルタの後処理");
    }
}
