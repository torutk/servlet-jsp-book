package book.chapter23;

import book.bean.Product;
import book.dao.ProductDAO;
import book.tool.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class SearchAction extends Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");

        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.search(keyword);

        request.setAttribute("list", list);

        return "list.jsp";
    }
}
