package lk.ijse.bootstrapping;

/*
    @author DanujaV
    @created 10/10/23 - 10:39 AM   
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppInitializer {
    private static Connection connection;
    private static Statement statement;

    private static void loadAndRegisterDriver() throws SQLException, ClassNotFoundException {
//        DriverManager.registerDriver(new Driver());

        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    private static void establishedTheConnection() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Danu25412541@"
        );

        System.out.println("connection: " + connection);
    }

    private static void createTheStatement() throws SQLException {
        statement = connection.createStatement();
    }

    private static void executeTheQuery() throws SQLException {
        String sql = "INSERT INTO user VALUES('U003', 'Sapumal', 'sap984', '+94 647548755')";

        int affectedRows = statement.executeUpdate(sql);
        System.out.println("affectedRows: " + affectedRows);

        System.out.println(affectedRows > 0 ? "user inserted!" : "oops! something went wrong!");
    }

    private static void closeTheConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        loadAndRegisterDriver();

        establishedTheConnection();

        createTheStatement();

        executeTheQuery();

        closeTheConnection();
    }
}
