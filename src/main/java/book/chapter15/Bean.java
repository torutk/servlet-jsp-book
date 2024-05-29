package book.chapter15;

import book.bean.Product;
import book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/chapter15/bean"})
public class Bean extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        Product p = new Product();

        p.setId(1);
        p.setName("まぐろ");
        p.setPrice(100);

        out.println(p.getId());
        out.println(":");
        out.println(p.getName());
        out.println(":");
        out.println(p.getPrice());

        Page.footer(out);
    }
}
