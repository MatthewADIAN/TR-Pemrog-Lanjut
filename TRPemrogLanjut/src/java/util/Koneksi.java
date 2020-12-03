/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author USER
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {
    private String dbDriver = "com.mysql.jdbc.Driver";
    private String dbUsername = "root";
    private String dbPass = "";
    private String dbUrl = "jdbc:mysql://localhost/db_makanan_pl";

    private Connection conn;
    
    public Koneksi(){
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbUrl, dbUsername, dbPass);
        } catch (Exception e) {
            conn = null;
        }
    }

    public Connection getConn() {
        return conn;
    }

}
