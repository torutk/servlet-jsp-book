package book.chapter17;

import book.bean.Product;
import book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/chapter17/cart-get"})
public class CartGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        HttpSession session = req.getSession();

        @SuppressWarnings("unchecked")
        List<Product> cart = (List) session.getAttribute("cart");
        if (cart != null) {
            for (Product p : cart) {
                out.println("<p>");
                out.println(p.getName());
                out.println(":");
                out.println(p.getPrice());
                out.println("</p>");
            }
        }
        Page.footer(out);
    }
}
