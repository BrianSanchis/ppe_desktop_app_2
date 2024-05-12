package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBSingleton {
	
	private static Connection connection;
    private static DBSingleton instance;

    private DBSingleton() throws SQLException {
        // URL de connexion à la base de données Railway MySQL
        String url = "jdbc:mysql://monorail.proxy.rlwy.net:14777/railway";
        String user = "root";
        String password = "cZFJeLWxoEhnQfkdThGvvEKnxUwjVvRQ";

        connection = DriverManager.getConnection(url, user, password);
    }

    public static DBSingleton getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}