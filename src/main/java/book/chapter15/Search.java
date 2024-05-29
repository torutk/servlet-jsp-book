package book.chapter15;

import book.bean.Product;
import book.dao.ProductDAO;
import book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/chapter15/search"})
public class Search extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        try {
            String keyword = req.getParameter("keyword");

            ProductDAO dao = new ProductDAO();
            List<Product> list = dao.search(keyword);
            for (Product p : list) {
                out.println(p.getId());
                out.println(":");
                out.println(p.getName());
                out.println(":");
                out.println(p.getPrice());
                out.println("<br>");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
