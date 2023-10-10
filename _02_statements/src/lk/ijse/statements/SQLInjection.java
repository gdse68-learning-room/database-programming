package lk.ijse.statements;

/*
    @author DanujaV
    @created 10/10/23 - 12:37 PM   
*/

import java.sql.*;

public class SQLInjection {
    private static void getUserByIdWithCreateStatement(String id) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Danu25412541@"
        );

        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM user WHERE user_name=" + id;
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String userName = resultSet.getString(1);
            String name = resultSet.getString(2);
            String password = resultSet.getString(3);
            String tel = resultSet.getString(4);

            System.out.println(userName + " - " + name + " - " + password + " - " + tel);
        }

        connection.close();
    }

    private static void getUserByIdWithPrepareStatement(String user_name) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Danu25412541@");

//        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM user WHERE user_name = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, user_name);

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            String userName = resultSet.getString(1);
            String name = resultSet.getString(2);
            String password = resultSet.getString(3);
            String tel = resultSet.getString(4);

            System.out.println(userName + " - " + name + " - " + password + " - " + tel);
        }
        connection.close();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        getUserByIdWithCreateStatement("'U0010' OR 1=1");
        getUserByIdWithPrepareStatement("U0010 OR 1=1");
    }
}
