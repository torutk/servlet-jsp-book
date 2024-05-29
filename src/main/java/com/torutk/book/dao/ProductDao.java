package com.torutk.book.dao;

import com.torutk.book.bean.Product;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends Dao {
    public List<Product> search(String keyword) throws SQLException, NamingException {
        List<Product> products = new ArrayList<>();
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(
                     "select * from product where name like ?"
             )
        ) {
            st.setString(1, "%" + keyword + "%");
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    var product = new Product(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("price")
                    );
                    products.add(product);
                }
            }
            return products;
        }
    }

    public int insert(Product product) throws SQLException, NamingException {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(
                     "insert into product(name, price) values(?, ?)")
        ) {
            st.setString(1, product.name());
            st.setInt(2, product.price());
            return st.executeUpdate();
        }
    }
}
