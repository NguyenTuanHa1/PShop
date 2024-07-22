package dao;

import entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class CartDB extends DBTest{
    public boolean clearCart(int userId) {
        String query = "DELETE FROM cart_products WHERE cartId = (SELECT cartId FROM carts WHERE userId = ?)";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return false;
    }

    public Cart createCart(int userId) {
        String query = "INSERT INTO carts (userId) VALUES (?)";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return new Cart(rs.getInt(1), userId);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<CartProducts> getCartItems(int userId) {
        List<CartProducts> list = new ArrayList<>();
        String query = "SELECT p.*, "
                + "d.*, "
                + "c.*, "
                + "cp.quantity, "
                + "(p.priceProduct - (p.priceProduct * d.discountPercentage / 100)) AS priceAfterDiscount, "
                + "cp.createdDate "
                + "FROM carts c "
                + "JOIN "
                + "cart_products cp ON c.cartId = cp.cartId "
                + "JOIN "
                + "products p ON cp.productId = p.productId "
                + "LEFT JOIN "
                + "discount d ON cp.discountId = d.discountId "
                + "WHERE "
                + "c.userId = ? "
                + "ORDER BY "
                + "cp.createdDate DESC;";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getString(12),
                        rs.getDate(13),
                        rs.getDate(14),
                        rs.getBoolean(15),
                        rs.getInt(27));

                Discount discount = new Discount(rs.getInt(16),
                        rs.getFloat(17),
                        rs.getDate(18),
                        rs.getDate(19),
                        rs.getBoolean(20));
                Cart cart = new Cart(rs.getInt(23),
                        rs.getInt(24),
                        rs.getDate(25));
                list.add(new CartProducts(product, discount, rs.getInt(26)));
            }
        } catch (SQLException e) {
            System.out.println(22);
            System.out.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return list;
    }

    public boolean checkProductInCart(int cartId, int productId) {
        String query = "SELECT * FROM cart_products WHERE cartId = ? AND productId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, cartId);
            ps.setInt(2, productId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return false;
    }

    public Cart getCart(int userId) {
        String query = "SELECT u.*, c.*" +
                "FROM carts c " +
                "JOIN users u ON c.userId = u.userId " +
                "WHERE c.userId = ?";

        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getBoolean(14),
                        rs.getString(15),
                        rs.getDate(16),
                        rs.getDate(17),
                        rs.getBoolean(18));
                return new Cart(rs.getInt(19), user, rs.getDate(21));
            }
        } catch (SQLException e) {
            System.out.println(333);
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public void updateQuantityProductInCart(int cartId, int productId, int quantity) {
        String query = "UPDATE cart_products SET quantity = ? WHERE productId = ? AND cartId = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setInt(2, productId);
            ps.setInt(3, cartId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(4444);
        } finally {
            closeConnection();
        }
    }

    public void addProductToCart(int userId, int productId, int quantity) {
        String query = "INSERT INTO cart_products (cartId, productId, quantity, discountId) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            Cart cart = getCart(userId);
            int cartId = cart.getCartId();

            ps.setInt(1, cartId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);

            DiscountDB discountDB = new DiscountDB();
            Discount discount = discountDB.getDiscountByProductId(productId);
            if (discount != null) {
                ps.setInt(4, discount.getDiscountId());
            } else {
                ps.setNull(4, Types.INTEGER);
            }

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error adding product to cart:");
            e.printStackTrace();
        }
    }


    public void removeProductFromCart(int cartProductId) {
        String query = "DELETE FROM cart_products WHERE productId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cartProductId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }
}
