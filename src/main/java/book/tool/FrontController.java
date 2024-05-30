package book.tool;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"*.action"})
public class FrontController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            String path = req.getServletPath().substring(1);
            String name = "book." + path.replace(".a", "A").replace('/', '.');
            Action action = (Action) Class.forName(name).getDeclaredConstructor().newInstance();
            String url = action.execute(req, resp);
            req.getRequestDispatcher(url).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
