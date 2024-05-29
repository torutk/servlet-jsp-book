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

@WebServlet(urlPatterns = {"/chapter15/insert"})
public class Insert extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        try {
            String name = req.getParameter("name");
            int price = Integer.parseInt(req.getParameter("price"));

            Product p = new Product();
            p.setName(name);
            p.setPrice(price);

            ProductDAO dao = new ProductDAO();
            int line = dao.insert(p);

            if (line > 0) {
                out.println("追加に成功しました。");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
