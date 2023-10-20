package pl.kurs.zadanieCar.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    public Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/samochody?useSSL=false&serverTimezone=UTC",
                    "root",
                    "root");

    public Config() throws SQLException {
    }

    public Connection getConnection() throws SQLException {
        return connection;
    }
}
