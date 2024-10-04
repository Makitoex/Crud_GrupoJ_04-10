package com.example.crud_grupoj_04_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconexion {
    private static final String DB_URL = "jdbc:sqlserver://[192.168.224.1]:1433;databaseName=Contactos;user=[myuser];password=[makito591];";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
