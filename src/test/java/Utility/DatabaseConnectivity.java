package Utility;

import java.sql.*;

public class DatabaseConnectivity {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("", "", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet getStatement(String query) {
        try (Statement statement = getConnection().createStatement()) {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
