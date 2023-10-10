package lk.ijse.statements;

/*
    @author DanujaV
    @created 10/10/23 - 12:37 PM   
*/

import java.sql.*;

public class CreateStatementDemo {
    private static void saveUser() throws ClassNotFoundException, SQLException {
        //since JDBC 4.x -> not compulsory to load the Driver
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //2nd step
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Danu25412541@");

        //3rd step
        Statement statement = connection.createStatement();

        //4th step
        String sql = "INSERT INTO user VALUES('U004', 'Dananjaya', '123', '075654125')";
        int affectedRows = statement.executeUpdate(sql);

        System.out.println(affectedRows > 0 ? "user saved!" : "user not saved!");

        //5th step
        connection.close();
    }

    private static void getAllUser() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Danu25412541@");

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM user";

        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            String userName = resultSet.getString("user_name");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            String tel = resultSet.getString("tel");

            System.out.println(userName + " - " + name + " - " + password + " - " + tel);
        }
        connection.close();
    }

    private static void getUserById(String id) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Danu25412541@"
        );

        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM user WHERE user_name=" + id;
        ResultSet resultSet = statement.executeQuery(sql);

        if(resultSet.next()) {
            String user_name = resultSet.getString(1);
            String name = resultSet.getString(2);
            String password = resultSet.getString(3);
            String tel = resultSet.getString(4);


            System.out.println(user_name + " - " + name + " - " + password + " - " + tel);
        }

        connection.close();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        saveUser();

//        getAllUser();

        getUserById("'U004'");
    }
}
