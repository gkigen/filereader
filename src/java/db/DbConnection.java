/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author kigen
 */
public class DbConnection {
  private final String driver = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/examples";
    private final String username = "root";
    private final String password = "";

    public DbConnection() {
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(URL, username, password);
            System.err.println("Successfully Connected");
        } catch (Exception e) {
            System.err.println("Unable To Obtain Connection");
            e.printStackTrace();
        }
        return conn;
    }  
}
