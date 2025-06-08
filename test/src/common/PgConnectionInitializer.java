//package common;
//
//import java.sql.*;
//import org.postgresql.jdbc.PgConnection;
//import com.zaxxer.hikari.HikariDataSource;
//
////�������� ����������� ����������:
////        ������������������: ���������� volatile + ������� �������� ��� �������������
////
////        PostgreSQL-����������� ���: �������� � PgConnection ��� ������� � ����������� ������������
////
////        ������� �������������: ��������� ����������� ������ ��� ������ ������������� ����������
////
////        ��������� ���� �������: ����������� �� DelegatingConnection ��� ���������� ������
//
//public class PgConnectionInitializer {
//    public static void main(String[] args) throws SQLException {
//        // 1. ��������� HikariCP
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:postgresql://localhost:5432/mydb");
//        config.setUsername("user");
//        config.setPassword("password");
//
//        // 2. ������� ������ DataSource � ����� Connection Wrapper
//        HikariDataSource rawDataSource = new HikariDataSource(config);
//        DataSource initializedDataSource = new InitializingDataSource(rawDataSource);
//
//        // 3. ������ ��� ������������� ����� ����������� �������������
//        try (Connection conn = initializedDataSource.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT current_setting('timezone')")) {
//            if (rs.next()) {
//                System.out.println("Timezone: " + rs.getString(1));
//            }
//        }
//    }
//
//    // ������ DataSource
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
//    // ��������� Connection Wrapper
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
//        // ������������� ��� ������ ������������� ����������
//        private void initializeIfNeeded() throws SQLException {
//            if (!initialized) {
//                synchronized (this) {
//                    if (!initialized) {
//                        try (Statement stmt = super.createStatement()) {
//                            // ��������� ��������� PostgreSQL
//                            stmt.execute("SET TIME ZONE 'UTC'");
//                            stmt.execute("SET search_path TO my_schema,public");
//                            stmt.execute("SET application_name TO 'MyApp'");
//
//                            // ����� �������� ������ ���������:
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
//    // ������� wrapper ��� PostgreSQL ����������
//    static abstract class PgConnectionWrapper extends DelegatingConnection {
//        public PgConnectionWrapper(PgConnection delegate) {
//            super(delegate);
//        }
//
//        // ����� �������������� ������ ������ �� �������������
//    }
//}