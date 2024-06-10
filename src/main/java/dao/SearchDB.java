package dao;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchDB extends DBTest{
    public List<Product> searchByKeyword(String keyword) {
        String query = "select p.*, t.typeProductName, s.sizeName, tm.trademarkName from products p\n"
                + "join TypeProduct t on p.typeProductId = t.typeProductId\n"
                + "join Size s on p.sizeId = s.sizeId\n"
                + "join Trademark tm on p.trademarkId = tm.trademarkId\n"
                + "where p.productName like ? or p.describeProduct like ? or t.typeProductName like ? or tm.trademarkName like ?";
        try {
            openConnection();
            ps = conn.prepareStatement(query);
            String keywordPattern = "%" + keyword + "%";
            ps.setString(1, keywordPattern);
            ps.setString(2, keywordPattern);
            ps.setString(3, keywordPattern);
            ps.setString(4, keywordPattern);

            rs = ps.executeQuery();
            List<Product> list = new ArrayList<>();
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
            return list;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }
}
