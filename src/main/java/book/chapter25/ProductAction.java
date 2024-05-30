package book.chapter25;

import book.bean.Product;
import book.dao.ProductDAO;
import book.tool.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class ProductAction extends Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        String keyword = request.getParameter("keyword");
        if (keyword == null) {
            keyword = "";
        }
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.search(keyword);

        session.setAttribute("list", list);

        return "product.jsp";
    }
}
