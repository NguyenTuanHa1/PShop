package dao;

import Constrant.BaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author A
 */
public class DBContext implements BaseConnection {
    private static DBConnection instance;

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }

        return instance;
    }

    public static Connection getConnection()  {
        try{
            Class.forName(DRIVER_NAME);
            return DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e);
        }
        return null;
    }

    public static void closeConnection(Connection con, PreparedStatement pst) throws SQLException {
        try {
            if (con != null) {
                con.close();
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pst, ResultSet rs) throws SQLException {
        try {
            con.close();
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}

