package book.dao;

import book.bean.Item;
import book.bean.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class PurchaseDAO extends DAO {
    public boolean insert(List<Item> cart, String name, String address) throws Exception {
        Connection conn = getConnection();
        conn.setAutoCommit(false);

        for (Item item : cart) {
            PreparedStatement ps = conn.prepareStatement(
                    "insert into purchase(product_id, product_name, "+
                            "product_price, product_count, customer_name, "+
                            "customer_address) values(?, ?, ?, ?, ?, ?)");
            Product p = item.getProduct();
            ps.setInt(1, p.getId());
            ps.setString(2, p.getName());
            ps.setInt(3, p.getPrice());
            ps.setInt(4, item.getCount());
            ps.setString(5, name);
            ps.setString(6, address);
            int line = ps.executeUpdate();
            ps.close();

            if (line != 1) {
                conn.rollback();
                conn.setAutoCommit(true);
                conn.close();
                return false;
            }
        }
        conn.commit();
        conn.setAutoCommit(true);
        conn.close();
        return true;
    }
}
