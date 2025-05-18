package common;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;

public class HikariPostgresExample {
    public static void main(String[] args) throws Exception {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/mydb");
        config.setUsername("user");
        config.setPassword("password");
        config.setMaximumPoolSize(10);

        HikariDataSource hikariDataSource = new HikariDataSource(config);
        Connection connection = new CustomConnectionWrapper(hikariDataSource.getConnection());

        // Использование соединения
        connection.createStatement().execute("SELECT 1");

        connection.close();
    }
}
