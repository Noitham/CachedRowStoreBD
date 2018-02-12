/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachedstorebdgui.persist;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sun.rowset.CachedRowSetImpl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alumne
 */
public class SQLInterface {

    private CachedRowSetImpl crs;
    private final String url;

    public SQLInterface(String username, String password) {
        url = "jdbc:mysql://localhost/dbstore?user=" + username + "&password=" + password;
    }

    public boolean execQuery(String query) {
        Statement stmt = null;
        Connection conn = null;
        ResultSet resultSet = null;
        try {
            Class.forName(
                    "com.mysql.jdbc.Driver").newInstance();
            conn = (Connection) DriverManager.getConnection(url);
            stmt = (Statement) conn.createStatement();
            resultSet = stmt.executeQuery(query);
            // create CachedRowSet and populate
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
            // note that the connection is being closed

            conn.close();
            return true;

        } catch (SQLException se) {
            System.out.println(se.getMessage());
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public CachedRowSetImpl getRowSet() {
        return crs;
    }

    public boolean commitToDatabase(CachedRowSetImpl crs) {

        Connection conn = null;

        try {
            Class.forName(
                    "com.mysql.jdbc.Driver").newInstance();
            conn = (Connection) DriverManager.getConnection(url);
            // propagate changes and close connection
            crs.acceptChanges(conn);
            conn.close();
            return true;
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

} //END OF CLASS
