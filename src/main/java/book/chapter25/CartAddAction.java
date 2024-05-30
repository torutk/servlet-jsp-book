package book.chapter25;

import book.bean.Item;
import book.bean.Product;
import book.tool.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

public class CartAddAction extends Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("id"));

        @SuppressWarnings("unchecked")
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<Item>();
            session.setAttribute("cart", cart);
        }
        for (Item i : cart) {
            if (i.getProduct().getId() == id) {
                i.setCount(i.getCount() + 1);
                return "cart.jsp";
            }
        }
        @SuppressWarnings("unchecked")
        List<Product> list = (List<Product>) session.getAttribute("list");
        for (Product p : list) {
            if (p.getId() == id) {
                Item i = new Item();
                i.setProduct(p);
                i.setCount(1);
                cart.add(i);
            }
        }
        return "cart.jsp";
    }
}
