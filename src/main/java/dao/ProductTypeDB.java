package dao;

import entity.Product;
import entity.TypeProduct;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeDB extends DBTest{

    public void updateProductType(int typeProductId, String typeProductName, String describeType) {
        String query = "update TypeProduct set typeProductName = ?, describeType = ? where typeProductId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, typeProductName);
            ps.setString(2, describeType);
            ps.setInt(3, typeProductId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }
    public void deleteProductType(int typeProductId) {
        String query = "delete from TypeProduct where typeProductId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, typeProductId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }

    public List<TypeProduct> getAllProductType() {
        List<TypeProduct> list = new ArrayList<>();
        String query = "select typeProductId, typeProductName, describeType  from TypeProduct";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TypeProduct(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (Exception ignored) {
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<TypeProduct> getAllProductTypeWithQuantity() {
        List<TypeProduct> list = new ArrayList<>();
        String query = "select t.typeProductId, t.typeProductName, count(p.productId) as quantity\n"
                + "from typeproduct t\n"
                + "left join products p on t.typeProductId = p.typeProductId\n"
                + "group by t.typeProductId, t.typeProductName, t.describeType";
        try {
            conn = DBContext.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TypeProduct(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public TypeProduct findProductTypeByID(int typeProductId) {
        String query = "select * from TypeProduct where typeProductId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, typeProductId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new TypeProduct(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<Product> getProductTypeById(int typeId) {
        List<Product> list = new ArrayList<>();
        String query = "select p.*, t.typeProductName, s.sizeName, tm.trademarkName from products p\n"
                + "join TypeProduct t on p.typeProductId = t.typeProductId\n"
                + "join Size s on p.sizeId = s.sizeId\n"
                + "join Trademark tm on p.trademarkId = tm.trademarkId\n"
                + "where p.typeProductId = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            assert conn != null;
            ps = conn.prepareStatement(query);
            ps.setInt(1, typeId);
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

    public boolean addTypeProduct(TypeProduct typeProduct) {
        String query = "INSERT INTO TypeProduct (typeProductName, describeType) VALUES (?, ?)";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, typeProduct.getTypeProductName());
            ps.setString(2, typeProduct.getDescribeType());
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
