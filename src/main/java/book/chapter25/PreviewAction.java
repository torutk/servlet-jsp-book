package book.chapter25;

import book.bean.Item;
import book.tool.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class PreviewAction extends Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("customer") == null) {
            return "preview-error-login.jsp";
        }

        @SuppressWarnings("unchecked")
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        if (cart == null || cart.size() == 0) {
            return "preview-error-cart.jsp";
        }
        return "purchase-in.jsp";
    }
}
