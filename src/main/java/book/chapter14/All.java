package book.chapter14;

import book.tool.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(urlPatterns = {"/chapter14/all"})
public class All extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/book");
            Connection conn = ds.getConnection();

            PreparedStatement ps = conn.prepareStatement("select * from product");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                out.println(rs.getInt("id"));
                out.println(":");
                out.println(rs.getString("name"));
                out.println(":");
                out.println(rs.getInt("price"));
                out.println("<br>");
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }


}
