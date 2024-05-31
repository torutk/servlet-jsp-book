package book.chapter25;

import book.bean.Item;
import book.dao.PurchaseDAO;
import book.tool.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class PurchaseAction extends Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        if (name.isEmpty() || address.isEmpty()) {
            return "purchase-error-empty.jsp";
        }

        PurchaseDAO dao = new PurchaseDAO();

        @SuppressWarnings("unchecked")
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        if (cart == null || !dao.insert(cart, name, address)) {
            return "purchase-error-insert.jsp";
        }
        session.removeAttribute("cart");
        return "purchase-out.jsp";
    }
}
