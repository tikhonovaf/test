//package common;
//
//import java.sql.*;
//import org.postgresql.jdbc.PgConnection;
//import com.zaxxer.hikari.HikariDataSource;
//
////Ключевые особенности реализации:
////        Потокобезопасность: Используем volatile + двойную проверку для инициализации
////
////        PostgreSQL-специфичный код: Работаем с PgConnection для доступа к специфичным возможностям
////
////        Ленивая инициализация: Настройки выполняются только при первом использовании соединения
////
////        Поддержка всех методов: Наследуемся от DelegatingConnection для прозрачной работы
//
//public class PgConnectionInitializer {
//    public static void main(String[] args) throws SQLException {
//        // 1. Настройка HikariCP
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:postgresql://localhost:5432/mydb");
//        config.setUsername("user");
//        config.setPassword("password");
//
//        // 2. Создаем прокси DataSource с нашим Connection Wrapper
//        HikariDataSource rawDataSource = new HikariDataSource(config);
//        DataSource initializedDataSource = new InitializingDataSource(rawDataSource);
//
//        // 3. Теперь при использовании будет выполняться инициализация
//        try (Connection conn = initializedDataSource.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT current_setting('timezone')")) {
//            if (rs.next()) {
//                System.out.println("Timezone: " + rs.getString(1));
//            }
//        }
//    }
//
//    // Прокси DataSource
//    static class InitializingDataSource extends DelegatingDataSource {
//        public InitializingDataSource(DataSource delegate) {
//            super(delegate);
//        }
//
//        @Override
//        public Connection getConnection() throws SQLException {
//            return new InitializedConnectionWrapper(super.getConnection());
//        }
//    }
//
//    // Кастомный Connection Wrapper
//    static class InitializedConnectionWrapper extends PgConnectionWrapper {
//        private volatile boolean initialized = false;
//
//        public InitializedConnectionWrapper(Connection delegate) throws SQLException {
//            super((PgConnection) delegate);
//        }
//
//        @Override
//        public Statement createStatement() throws SQLException {
//            initializeIfNeeded();
//            return super.createStatement();
//        }
//
//        // Инициализация при первом использовании соединения
//        private void initializeIfNeeded() throws SQLException {
//            if (!initialized) {
//                synchronized (this) {
//                    if (!initialized) {
//                        try (Statement stmt = super.createStatement()) {
//                            // Выполняем настройки PostgreSQL
//                            stmt.execute("SET TIME ZONE 'UTC'");
//                            stmt.execute("SET search_path TO my_schema,public");
//                            stmt.execute("SET application_name TO 'MyApp'");
//
//                            // Можно добавить другие настройки:
//                            stmt.execute("SET lock_timeout TO '5s'");
//                            stmt.execute("SET statement_timeout TO '30000'");
//                        }
//                        initialized = true;
//                    }
//                }
//            }
//        }
//    }
//
//    // Базовый wrapper для PostgreSQL соединения
//    static abstract class PgConnectionWrapper extends DelegatingConnection {
//        public PgConnectionWrapper(PgConnection delegate) {
//            super(delegate);
//        }
//
//        // Можно переопределить другие методы по необходимости
//    }
//}