package dao;

import entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDB extends DBTest{

    // getProductByPriceRange
    public List<Product> getProductByPriceRange(int lower, int upper) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT p.*, t.typeProductName, s.sizeName, tm.trademarkName, "
                + "d.discountPercentage, "
                + "(p.priceProduct - (p.priceProduct * d.discountPercentage / 100)) AS priceAfterDiscount "
                + "FROM products p "
                + "JOIN TypeProduct t ON p.typeProductId = t.typeProductId "
                + "JOIN Size s ON p.sizeId = s.sizeId "
                + "JOIN Trademark tm ON p.trademarkId = tm.trademarkId "
                + "LEFT JOIN Product_Discount pd ON p.productId = pd.productId "
                + "LEFT JOIN Discount d ON pd.discountId = d.discountId "
                + "WHERE p.priceProduct >= ? AND p.priceProduct <= ? AND p.status = 1";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, lower);
            ps.setInt(2, upper);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
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
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getFloat(19),
                        rs.getInt(20)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return list;
    }
    public int getProductQuantity(int productId) {
        String query = "SELECT quantityProduct FROM products WHERE productId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return 0;
    }

    public void updateProductQuantity(int productId, int quantity) {
        String query = "UPDATE products SET quantityProduct = ? WHERE productId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setInt(2, productId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }

    public Product getDetailProductById(int id) {
        String query = "SELECT p.*, t.typeProductName, s.sizeName, tm.trademarkName, "
                + "d.discountPercentage, "
                + "(p.priceProduct - (p.priceProduct * d.discountPercentage / 100)) AS priceAfterDiscount "
                + "FROM products p "
                + "JOIN TypeProduct t ON p.typeProductId = t.typeProductId "
                + "JOIN Size s ON p.sizeId = s.sizeId "
                + "JOIN Trademark tm ON p.trademarkId = tm.trademarkId "
                + "LEFT JOIN Product_Discount pd ON p.productId = pd.productId "
                + "LEFT JOIN Discount d ON pd.discountId = d.discountId "
                + "WHERE p.productId = ? AND p.status = 1";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt(1),
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
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getFloat(19),
                        rs.getInt(20));
            }
        } catch (Exception ignored) {
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<Product> getRelatedProduct(int typeProductId, int productId) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT p.*, t.typeProductName, s.sizeName, tm.trademarkName, "
                + "d.discountPercentage, "
                + "(p.priceProduct - (p.priceProduct * d.discountPercentage / 100)) AS priceAfterDiscount "
                + "FROM products p "
                + "JOIN TypeProduct t ON p.typeProductId = t.typeProductId "
                + "JOIN Size s ON p.sizeId = s.sizeId "
                + "JOIN Trademark tm ON p.trademarkId = tm.trademarkId "
                + "LEFT JOIN Product_Discount pd ON p.productId = pd.productId "
                + "LEFT JOIN Discount d ON pd.discountId = d.discountId "
                + "where p.typeProductId = ? and p.productId != ?\n"
                + "order by p.productId desc limit 4";

        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, typeProductId);
            ps.setInt(2, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
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
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getFloat(19),
                        rs.getInt(20)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean checkUserBuyProduct(int productId, int userId) {
        String query = "SELECT * FROM billdetail bd\n"
                + "JOIN bill b ON bd.billId = b.billId\n"
                + "WHERE b.userId = ? AND bd.productId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }
    public Product getProductById(int id) {
        String query = "select p.*, t.typeProductName, s.sizeName, tm.trademarkName from products p\n"
                + "join TypeProduct t on p.typeProductId = t.typeProductId\n"
                + "join Size s on p.sizeId = s.sizeId\n"
                + "join Trademark tm on p.trademarkId = tm.trademarkId\n"
                + "where productId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
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
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18));
                System.out.println(product);
                return product;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public void editProduct(Product product) {
        String query = "UPDATE products SET productName = ?, img = ?, img1 = ?, img2 = ?, img3 = ?, priceProduct = ?, typeProductId = ?, sizeId = ?, trademarkId = ?, quantityProduct = ?, describeProduct = ?, status = ? WHERE productId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getImg());
            ps.setString(3, product.getImg1());
            ps.setString(4, product.getImg2());
            ps.setString(5, product.getImg3());
            ps.setInt(6, product.getPriceProduct());
            ps.setInt(7, product.getTypeProductId());
            ps.setInt(8, product.getSizeId());
            ps.setInt(9, product.getTrademarkId());
            ps.setInt(10, product.getQuantity());
            ps.setString(11, product.getDescribeProduct());
            ps.setBoolean(12, product.isStatus());
            ps.setInt(13, product.getProductId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }

    public boolean deleteProduct(int productId) {
        String query = "DELETE FROM products WHERE productId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean checkDiscountProduct(int productId) {
        String query = "SELECT * FROM product_discount WHERE productId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }
    public boolean addDiscountProduct(int productId, int discountId) {
        String query = "INSERT INTO product_discount (productId, discountId) VALUES (?, ?)";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2, discountId);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }
    public void changeDiscountProduct(int productId, int discountId) {
        String query = "UPDATE product_discount SET discountId = ? WHERE productId = ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, discountId);
            ps.setInt(2, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }
    public List<Product> getTopProduct(int limit) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT p.*, t.typeProductName, s.sizeName, tm.trademarkName, "
                + "d.discountPercentage, "
                + "(p.priceProduct - (p.priceProduct * d.discountPercentage / 100)) AS priceAfterDiscount "
                + "FROM products p "
                + "JOIN TypeProduct t ON p.typeProductId = t.typeProductId "
                + "JOIN Size s ON p.sizeId = s.sizeId "
                + "JOIN Trademark tm ON p.trademarkId = tm.trademarkId "
                + "LEFT JOIN Product_Discount pd ON p.productId = pd.productId "
                + "LEFT JOIN Discount d ON pd.discountId = d.discountId "
                + " limit ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, limit);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
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
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select p.*, t.typeProductName, s.sizeName, tm.trademarkName from products p\n"
                + "join TypeProduct t on p.typeProductId = t.typeProductId\n"
                + "join Size s on p.sizeId = s.sizeId\n"
                + "join Trademark tm on p.trademarkId = tm.trademarkId";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
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
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return list;
    }
    public boolean addProduct(Product product) {
        String query = "INSERT INTO products (productName, img, img1, img2, img3, priceProduct, typeProductId, sizeId, trademarkId, quantityProduct, describeProduct) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getImg());
            ps.setString(3, product.getImg1());
            ps.setString(4, product.getImg2());
            ps.setString(5, product.getImg3());
            ps.setInt(6, product.getPriceProduct());
            ps.setInt(7, product.getTypeProductId());
            ps.setInt(8, product.getSizeId());
            ps.setInt(9, product.getTrademarkId());
            ps.setInt(10, product.getQuantity());
            ps.setString(11, product.getDescribeProduct());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }

    // getTotalProduct
    public int getTotalProduct() {
        String query = "SELECT COUNT(*) FROM products WHERE status = 1";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return 0;
    }
    public List<Product> getAllProductWithDiscount(int offset, String sort, String typeSort) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT p.*, t.typeProductName, s.sizeName, tm.trademarkName, "
                + "d.discountPercentage, "
                + "(p.priceProduct - (p.priceProduct * d.discountPercentage / 100)) AS priceAfterDiscount "
                + "FROM products p "
                + "JOIN TypeProduct t ON p.typeProductId = t.typeProductId "
                + "JOIN Size s ON p.sizeId = s.sizeId "
                + "JOIN Trademark tm ON p.trademarkId = tm.trademarkId "
                + "LEFT JOIN Product_Discount pd ON p.productId = pd.productId "
                + "LEFT JOIN Discount d ON pd.discountId = d.discountId "
                + "WHERE p.status = 1 "
                + "ORDER BY p." + sort + " " + typeSort + " "
                + "LIMIT 9 OFFSET ?";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, offset);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
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
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getFloat(19),
                        rs.getInt(20)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean checkProductExistById(int id) {
        String query = "select * from products where productId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception ignored) {
        } finally {
            closeConnection();
        }
        return false;
    }
}
