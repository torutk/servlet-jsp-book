package book.chapter15;

import book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/chapter15/nobean"})
public class NoBean extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        int id = 1;
        String name = "マグロ";
        int price = 100;

        out.println(id);
        out.println(":");
        out.println(name);
        out.println(":");
        out.println(price);

        Page.footer(out);
    }
}
