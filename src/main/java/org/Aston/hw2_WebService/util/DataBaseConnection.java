package org.Aston.hw2_WebService.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
    private static final String propertiesPath = "src/main/resources/db.properties";
    private static final HikariConfig config;
    private static final HikariDataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertiesPath));
        } catch (IOException e) {
            System.out.println("Properties file doesn't exist");
        }
        config = new HikariConfig(properties);
        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
