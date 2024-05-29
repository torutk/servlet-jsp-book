package book.chapter6;

import book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/chapter6/checkbox"})
public class Checkbox extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("UTF-8");
        String[] genre = req.getParameterValues("genre");

        Page.header(out);
        if (genre != null) {
            for (String item : genre) {
                out.println("「" + item + "」");
            }
            out.println("に関するお買い得情報をお送りましす。");
        } else {
            out.println("お買い得情報はお送りしません。");
        }
        Page.footer(out);
    }
}
