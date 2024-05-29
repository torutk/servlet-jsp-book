package book.chapter19;

import book.tool.Page;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(urlPatterns = {"/chapter19/file"})
public class File extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        ServletContext context = getServletContext();
        String path = context.getRealPath("/WEB-INF/setting.txt");

        FileInputStream in = new FileInputStream(path);
        Properties p = new Properties();
        p.load(in);
        in.close();

        for (String key : p.stringPropertyNames()) {
            out.println("<p>" + key + " : " + p.getProperty(key) + "</p>");
        }

        Page.footer(out);
    }
}
