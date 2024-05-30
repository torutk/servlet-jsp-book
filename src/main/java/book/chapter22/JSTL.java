package book.chapter22;

import book.bean.Product;
import book.dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/chapter22/jstl"})
public class JSTL extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            ProductDAO dao = new ProductDAO();
            List<Product> list = dao.search("");

            req.setAttribute("list", list);

            req.getRequestDispatcher("jstl.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
