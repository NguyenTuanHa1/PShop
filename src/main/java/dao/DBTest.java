package dao;

import Constrant.BaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBTest implements BaseConnection {
    public static Connection conn;
    public static PreparedStatement ps;
    public static ResultSet rs;

    public static void openConnection() {
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e);
        }
    }
    public static void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception ignored) {
        }
    }
}
