package book.chapter14;

import book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(urlPatterns = {"/chapter14/insert"})
public class Insert extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/book");
            Connection conn = ds.getConnection();

            String name = req.getParameter("name");
            int price = Integer.parseInt(req.getParameter("price"));

            PreparedStatement ps = conn.prepareStatement("insert into product(name, price) values(?,?)");
            ps.setString(1, name);
            ps.setInt(2, price);
            int line = ps.executeUpdate();

            if (line > 0) {
                out.println("追加に成功しました。");
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
