package book.chapter12;

import book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/chapter12/request"})
public class Request extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        out.println("<p>Request URL<br>" + req.getRequestURL() + "</p>");
        out.println("<p>Host<br>" + req.getHeader("Host") + "</p>");
        out.println("<p>User-Agent<br>" + req.getHeader("User-Agent") + "</p>");
        out.println("<p>Remote-Address<br>" + req.getRemoteAddr() + "</p>");

        Page.footer(out);
    }
}
