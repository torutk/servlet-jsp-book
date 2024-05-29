package book.chapter5;

import book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/chapter5/total"})
public class Total extends HttpServlet {

    public void doPost(
            HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            request.setCharacterEncoding("UTF-8");
            int price = Integer.parseInt(request.getParameter("price"));
            int count = Integer.parseInt(request.getParameter("count"));

            Page.header(out);
            out.println(price + "円×");
            out.println(count + "個=");
            out.println(price * count + "円");
            Page.footer(out);

        } catch (NumberFormatException e) {
            out.println("数値を入力してください。");
        }
    }
}
