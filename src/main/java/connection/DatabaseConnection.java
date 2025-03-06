package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;

    private DatabaseConnection() {
    }

    private static final String url = "jdbc:mysql://localhost:3306/bloodpressuredb";
    private static final String user = "root";
    private static String password = "";

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;

    }

    public static void setPassword(String userPassword) {
        password = userPassword;
    }

    public static boolean testConnection(String password) {
        try {
            setPassword(password);
            DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
