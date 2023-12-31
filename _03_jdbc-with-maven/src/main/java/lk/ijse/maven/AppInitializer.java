package lk.ijse.maven;

/*
    @author DanujaV
    @created 10/10/23 - 2:15 PM   
*/

import java.sql.*;

public class AppInitializer {
    private static void saveCustomer(String id, String name, String address, String tel) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Danu25412541@"
        );

        String sql = "INSERT INTO customer VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);
        pstm.setString(2, name);
        pstm.setString(3, address);
        pstm.setString(4, tel);

        int affectedRows = pstm.executeUpdate();

        System.out.println(affectedRows > 0 ? "customer saved!" : "oops! something went wrong!");

        connection.close();
    }

    private static void deleteCustomer(String id) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kade",
                    "root",
                    "Danu25412541@"
            );

            String sql = "DELETE FROM customer WHERE id = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, id);

            int affectedRows = pstm.executeUpdate();
            System.out.println(affectedRows > 0 ? "customer deleted!" : "customer not deleted");

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void updateCustomer(String id, String newAddress, String newTel) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kade",
                    "root",
                    "Danu25412541@"
            );

            String sql = "UPDATE customer SET address = ?, tel = ? WHERE id = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, newAddress);
            pstm.setString(2, newTel);
            pstm.setString(3, id);

            int affectedRows = pstm.executeUpdate();
            System.out.println(affectedRows > 0 ? "customer updated!" : "customer not updated!");

            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void loadAllCustomers() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kade",
                    "root",
                    "Danu25412541@"
            );

            String sql = "SELECT * FROM customer";
            PreparedStatement pstm = connection.prepareStatement(sql);

            ResultSet resultSet = pstm.executeQuery();

            while(resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String tel = resultSet.getString(3);

                System.out.println(id + " - " + name + " - " + address + " - " + tel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getCustomerById(String id) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kade",
                    "root",
                    "Danu25412541@"
            );

            String sql = "SELECT * FROM customer WHERE id = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);

            ResultSet resultSet = pstm.executeQuery();

            if(resultSet.next()) {
                String cus_id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String tel = resultSet.getString(3);

                System.out.println(cus_id + " - " + name + " - " + address + " - " + tel);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
//        saveCustomer("C001", "Saman", "Panadura", "0745845627");

//        deleteCustomer("C001");

//        updateCustomer("C001", "Galle", "+94 774568796");

//        loadAllCustomers();

        getCustomerById("C001");
    }
}
