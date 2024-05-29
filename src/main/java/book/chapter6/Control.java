package book.chapter6;

import book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = {"/chapter6/control"})
public class Control extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        Page.header(out);

        req.setCharacterEncoding("utf-8");
        List<String> names = Collections.list(req.getParameterNames());
        for (String name : names) {
            String[] valuess = req.getParameterValues(name);
            for (String value : valuess) {
                out.println("<p>" + name + " = " + value + "</p>");
            }
        }
        Page.footer(out);
    }

}
