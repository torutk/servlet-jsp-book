package book.chapter23;

import book.bean.Product;
import book.dao.ProductDAO;
import book.tool.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class InsertAction extends Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));

        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        ProductDAO dao = new ProductDAO();
        dao.insert(p);

        List<Product> list = dao.search("");
        request.setAttribute("list", list);

        return "list.jsp";
    }
}
