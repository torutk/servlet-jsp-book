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

@WebServlet(urlPatterns = {"/chapter14/transaction"})
public class Transaction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/book");
            Connection con = ds.getConnection();

            String name = req.getParameter("name");
            int price = Integer.parseInt(req.getParameter("price"));

            con.setAutoCommit(false);

            PreparedStatement ps = con.prepareStatement("insert into product(name, price) values(?,?)");
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.executeUpdate();

            ps = con.prepareStatement("select * from product where name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            int line = 0;
            while (rs.next()) {
                line++;
            }
            if (line == 1) {
                con.commit();
                out.println("商品を登録しました。");
            } else {
                con.rollback();
                out.println("商品は既に登録されています。");
            }

            con.setAutoCommit(true);

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
