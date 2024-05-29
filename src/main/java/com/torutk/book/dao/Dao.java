package com.torutk.book.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Dao {
    private static DataSource dataSource;

    protected Connection getConnection() throws SQLException, NamingException {
        if (dataSource == null) {
            InitialContext ic = null;
            try {
                ic = new InitialContext();
                dataSource = (DataSource) ic.lookup("java:comp/env/jdbc/book");
            } finally {
                if (ic != null) {
                    ic.close();
                }
            }
        }
        return dataSource.getConnection();
    }
}
