package com.src.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoService {
    private Connection con = null;

    public PreparedStatement getMyPreparedStatement(String sql) throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=chakri;integratedSecurity=true ;encrypt=true;trustServerCertificate=true;");
            return con.prepareStatement(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Error loading database driver.");
        }
    }

    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
