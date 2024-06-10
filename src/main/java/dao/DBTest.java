package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBTest {
    public static Connection conn;
    public static PreparedStatement ps;
    public static ResultSet rs;

    public static void openConnection() {
        try {
            conn = DBContext.getConnection();
            assert conn != null;
        } catch (Exception ignored) {
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
