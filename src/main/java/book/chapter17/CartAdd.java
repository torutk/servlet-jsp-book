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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/chapter17/cart-add"})
public class CartAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));

        HttpSession session = req.getSession();

        @SuppressWarnings("unchecked")
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        cart.add(p);

        session.setAttribute("cart", cart);

        out.println("カートに商品を追加しました。");
        Page.footer(out);
    }
}
