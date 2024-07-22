package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StatisticsDAO {

    // getRevenueBetweenDates
    public Map<String, Long> getRevenueBetweenDates(String fromDate, String toDate) {
        Map<String, Long> revenueData = new LinkedHashMap<>();
        String query = "SELECT DATE(createdDate) AS date, SUM(totalPrice) AS dailyRevenue FROM bill WHERE DATE(createdDate) BETWEEN ? AND ? GROUP BY DATE(createdDate)";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String date = rs.getString("date");
                    Long revenue = rs.getLong("dailyRevenue");
                    revenueData.put(date, revenue);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return revenueData;
    }


    public Map<String, Object> getStatistics() {
        Map<String, Object> statistics = new HashMap<>();
        String dailyRevenueQuery = "SELECT SUM(totalPrice) AS dailyRevenue FROM bill WHERE DATE(createdDate) = CURDATE()";
        String monthlyRevenueQuery = "SELECT SUM(totalPrice) AS monthlyRevenue FROM bill WHERE MONTH(createdDate) = MONTH(CURDATE()) AND YEAR(createdDate) = YEAR(CURDATE())";
        String yearlyRevenueQuery = "SELECT SUM(totalPrice) AS yearlyRevenue FROM bill WHERE YEAR(createdDate) = YEAR(CURDATE())";
        String customerCountQuery = "SELECT COUNT(DISTINCT userId) AS customerCount FROM bill";
        String soldItemsCountQuery = "SELECT SUM(quantity) AS soldItemsCount FROM billdetail";
        // Get productName, productId of product through productID
        String bestSellerQuery = "SELECT productName, billdetail.productId as productId, SUM(quantity) AS soldQuantity FROM billdetail JOIN products ON billdetail.productId = products.productId GROUP BY productId ORDER BY soldQuantity DESC LIMIT 1";
        String soldItemThisMonth = "SELECT SUM(quantity) AS soldItemsCount FROM billdetail WHERE MONTH(createdDate) = MONTH(CURDATE()) AND YEAR(createdDate) = YEAR(CURDATE())";
        String soldItemToday = "SELECT SUM(quantity) AS soldItemsCount FROM billdetail WHERE DATE(createdDate) = CURDATE()";

        try (Connection conn = DBContext.getConnection()) {
            // Daily Revenue
            assert conn != null;
            try (PreparedStatement ps = conn.prepareStatement(dailyRevenueQuery); ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    statistics.put("dailyRevenue", rs.getLong("dailyRevenue"));
                }
            }

            // Monthly Revenue
            try (PreparedStatement ps = conn.prepareStatement(monthlyRevenueQuery); ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    statistics.put("monthlyRevenue", rs.getLong("monthlyRevenue"));
                }
            }

            // Yearly Revenue
            try (PreparedStatement ps = conn.prepareStatement(yearlyRevenueQuery); ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    statistics.put("yearlyRevenue", rs.getLong("yearlyRevenue"));
                }
            }

            // Customer Count
            try (PreparedStatement ps = conn.prepareStatement(customerCountQuery); ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    statistics.put("customerCount", rs.getLong("customerCount"));
                }
            }

            // Sold Items Count
            try (PreparedStatement ps = conn.prepareStatement(soldItemsCountQuery); ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    statistics.put("soldItemsCount", rs.getLong("soldItemsCount"));
                }
            }

            // Best Seller
            try (PreparedStatement ps = conn.prepareStatement(bestSellerQuery); ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    statistics.put("bestSeller", rs.getString("productName"));
                    statistics.put("bestSellerID", rs.getInt("productId"));
                    statistics.put("bestSellerQuantity", rs.getInt("soldQuantity"));
                }
            }

            // Sold Items This Month
            try (PreparedStatement ps = conn.prepareStatement(soldItemThisMonth); ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    statistics.put("soldItemsThisMonth", rs.getLong("soldItemsCount"));
                }
            }

            // Sold Items Today
            try (PreparedStatement ps = conn.prepareStatement(soldItemToday); ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    statistics.put("soldItemsToday", rs.getLong("soldItemsCount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statistics;
    }
}
