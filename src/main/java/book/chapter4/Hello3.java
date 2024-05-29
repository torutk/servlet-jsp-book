package book.chapter4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Hello3 extends HttpServlet {

    public void doGet(
            HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Servlet/JSP Sample Programs</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<p>Hello!</p>");
        out.println("<p>こんにちは！</p>");
        out.println("<p>" + new java.util.Date() + "</p>");

        out.println("</body>");
        out.println("</html>");
    }
}
