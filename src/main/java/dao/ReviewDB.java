package dao;

import entity.Review;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDB extends DBTest{
    public List<Review> getAllReviewByProductId(int productId) {
        List<Review> list = new ArrayList<>();
        String query = "select r.*, u.name, u.avatar, p.productName from review r\n"
                + "join users u on r.userId = u.userID\n"
                + "join products p on r.productId = p.productId\n"
                + "where r.productId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Review(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean addReview(Review review) {
        String query = "INSERT INTO review (productId, userId, starQuantity, content) VALUES (?, ?, ?, ?)";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, review.getProductId());
            ps.setInt(2, review.getUserId());
            ps.setInt(3, review.getStarQuantity());
            ps.setString(4, review.getContent());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean deleteReview(int reviewId) {
        String query = "DELETE FROM review WHERE reviewId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, reviewId);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }
}
