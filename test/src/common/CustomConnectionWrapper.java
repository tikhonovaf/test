package common;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomConnectionWrapper {
    private final Connection connection;
    private boolean isNew = true;

    public CustomConnectionWrapper(Connection connection) {
        this.connection = connection;
    }

    public Statement createStatement() throws SQLException {
        if (isNew) {
            System.out.println("Инициализация нового соединения...");
            connection.createStatement().execute("SET SESSION lock_timeout = 10000");
            isNew = false;
        }
        return connection.createStatement();
    }

    public void close() throws SQLException {
        connection.close();
    }

    public boolean isNew() {
        return isNew;
    }
}
