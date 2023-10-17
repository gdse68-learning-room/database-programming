package lk.ijse.singleton;

public class DbConnection {
    private static DbConnection dbConnection;

    private DbConnection() {

    }

    public static DbConnection getInstance() {
        if(dbConnection == null) {
            dbConnection = new DbConnection();
            return dbConnection;
        } else {
            return dbConnection;
        }
    }
}
