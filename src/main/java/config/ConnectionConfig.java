package config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionConfig {
    /*public static Properties loadProperties(String resourceFileName) throws IOException {
        Properties configuration = new Properties();
        InputStream inputStream = ConnectionConfig.class
                .getClassLoader().getResourceAsStream(resourceFileName);
        configuration.load(inputStream);
        if (inputStream != null){
            inputStream.close();
        }

        return configuration;
    }

    public static Connection getConnection(){
        Properties properties;
        Connection connection;

        try{
            properties = loadProperties("application.properties");
            String url = properties.getProperty("datasource.url");
            String user = properties.getProperty("datasource.name");
            String password = properties.getProperty("datasource.password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }*/


}
