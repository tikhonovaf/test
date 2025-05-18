package common;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.DelegatingConnection;
import org.apache.commons.dbcp2.DelegatingDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class GenericConnectionInitializer {

    public static void main(String[] args) throws SQLException {
        // 1. Настройка HikariCP
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/mydb");
        config.setUsername("user");
        config.setPassword("password");

        // 2. Создаем прокси DataSource
        HikariDataSource rawDataSource = new HikariDataSource(config);
        DataSource initializedDataSource = new InitializingDataSource(rawDataSource);

        // 3. Использование (инициализация выполнится автоматически)
        try (Connection conn = initializedDataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT 1")) {
            System.out.println("Connection test successful");
        }
    }

    // Прокси для DataSource
    static class InitializingDataSource extends DelegatingDataSource {
        public InitializingDataSource(DataSource delegate) {
            super(delegate);
        }

        @Override
        public Connection getConnection() throws SQLException {
            return new InitializedConnectionWrapper(super.getConnection());
        }
    }

    // Кастомный Connection Wrapper
    static class InitializedConnectionWrapper extends DelegatingConnection {
        private volatile boolean initialized = false;

        public InitializedConnectionWrapper(Connection delegate) {
            super(delegate);
        }

        @Override
        public Statement createStatement() throws SQLException {
            initializeOnce();
            return super.createStatement();
        }

        // Переопределяем другие методы, которые могут быть точками входа
        @Override
        public PreparedStatement prepareStatement(String sql) throws SQLException {
            initializeOnce();
            return super.prepareStatement(sql);
        }

        @Override
        public CallableStatement prepareCall(String sql) throws SQLException {
            initializeOnce();
            return super.prepareCall(sql);
        }

        private void initializeOnce() throws SQLException {
            if (!initialized) {
                synchronized (this) {
                    if (!initialized) {
                        doInitialize();
                        initialized = true;
                    }
                }
            }
        }

        protected void doInitialize() throws SQLException {
            try (Statement stmt = super.createStatement()) {
                // PostgreSQL-специфичные настройки (будут работать через стандартный JDBC)
                stmt.execute("SET TIME ZONE 'UTC'");
                stmt.execute("SET search_path TO my_schema,public");

                // Общие SQL-настройки
                stmt.execute("SET lock_timeout TO '5s'");

                // Можно добавить логирование
                System.out.println("Connection initialized with custom settings");
            }
        }
    }
}