/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import db.DbConnection;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author kigen
 */
public class PersonReader {

    DbConnection db = new DbConnection();
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public PersonReader() {
        conn = db.getConnection();

    }

    public static void main(String[] args) {
        PersonReader pr = new PersonReader();
        pr.loadfile();
    }

    public void loadfile() {
        try {
            Scanner scanner = new Scanner(new FileReader("C:\\code\\backup\\person.csv"));
            scanner.next();
            while (scanner.hasNext()) {
                String data = scanner.next();
                String[] results = data.split(",");
                String name = results[0];
                // System.out.println(results[0]);
                String date = results[1];
                String color = results[2];
                String allergy = results[3];
                try {
                    String sql = "insert into person(name,date,color,allergy) values(?,?,?,?)";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, name);
                    pst.setString(2, date);
                    pst.setString(3, color);
                    pst.setString(4,  allergy);
                    pst.executeUpdate();
                    System.out.println("Records inserted into person table!");
                } catch (SQLException e) {
                }

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
