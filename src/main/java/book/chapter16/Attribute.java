package book.chapter16;

import book.bean.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/chapter16/attribute"})
public class Attribute extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product p = new Product();
        p.setId(1);
        p.setName("まぐろ");
        p.setPrice(100);

        req.setAttribute("product", p);

        req.getRequestDispatcher("attribute.jsp").forward(req, resp);
    }
}
