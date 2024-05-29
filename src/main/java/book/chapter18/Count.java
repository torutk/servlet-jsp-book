package book.chapter18;

import book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/chapter18/count"})
public class Count extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        Cookie[] cookies = req.getCookies();

        Integer count = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("count")) {
                    count = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }

        if (count == null) {
            count = 0;
        }
        count++;

        Cookie cookie = new Cookie("count", count.toString());
        cookie.setMaxAge(60 * 60 * 24);
        resp.addCookie(cookie);

        out.println(count);
        Page.footer(out);
    }
}
