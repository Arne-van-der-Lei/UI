/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.HashMap;
import java.util.Map;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arne.vanderlei
 */
public class DB {

    final static String DBPAD = "src/database/DP.mdb";
    final static String DB = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + DBPAD;
    public Connection con;

    public DB() {

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e);
        }

        try {
            con = DriverManager.getConnection(DB, "", "");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

    }

    public Map<String, Float> getString() {
        Map<String, Float> ret = new HashMap<String, Float>();

        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from producten");
            if (rs != null) {
                while (rs.next()) {
                    ret.put( rs.getString("Productnaam"),rs.getFloat("Prijs"));
                }
            }//ok
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;

    }
}
