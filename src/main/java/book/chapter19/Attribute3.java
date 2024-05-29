package book.chapter19;

import book.tool.Page;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/chapter19/attribute3"})
public class Attribute3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        ServletContext context = getServletContext();

        String debug = (String) context.getAttribute("debug");
        if (debug.equals("yes")) {
            out.println("<p>デバッグモードで実行します。</p>");
        }

        int memory = Integer.parseInt((String) context.getAttribute("memory"));
        if (memory < 1000000) {
            out.println("<p>省メモリモードで実行します。");
        }

        Page.footer(out);
    }
}
