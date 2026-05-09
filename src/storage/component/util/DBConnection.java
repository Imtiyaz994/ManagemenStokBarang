package storage.component.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBConnection {
    
    private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException, IOException {
        if (connection == null || connection.isClosed() || !connection.isValid(3)) {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("db.properties");
            prop.load(fis);
            
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");
            
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}