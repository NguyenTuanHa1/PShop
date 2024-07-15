package dao;

import entity.Transport;

import java.util.ArrayList;
import java.util.List;

public class TransportDB extends DBTest{
    public void deleteTransport(int transportId) {
        String query = "DELETE FROM transport WHERE transportId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, transportId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }
    public void updateTransport(Transport transport) {
        String query = "UPDATE transport SET transportName = ?, priceTransPort = ?, descriptionTransport = ? WHERE transportId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, transport.getTransportName());
            ps.setInt(2, transport.getPriceTransPort());
            ps.setString(3, transport.getDescriptionTransport());
            ps.setInt(4, transport.getTransportId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }
    public Transport getTransportById(int transportId) {
        String query = "SELECT * FROM transport WHERE transportId = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, transportId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Transport(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return null;
    }

    public static boolean addTransport(String transportName, int priceTransPort, String descriptionTransport) {
        String query = "INSERT INTO transport (transportName, priceTransPort, descriptionTransport) VALUES (?, ?, ?)";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, transportName);
            ps.setInt(2, priceTransPort);
            ps.setString(3, descriptionTransport);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return false;
    }

    public List<Transport> getAllTransport() {
        List<Transport> list = new ArrayList<>();
        String query = "select * from transport";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            assert conn != null;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Transport(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return list;
    }
}
