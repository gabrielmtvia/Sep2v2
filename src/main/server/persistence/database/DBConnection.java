package main.server.persistence.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection implements DBConnectionModel {

    private final String url = "jdbc:postgresql://abul.db.elephantsql.com/unmjzkfa?currentSchema=\"GYM\"";
    private final String username = "unmjzkfa";
    private final String password ="BrDPIIo-EZN8SwzYMLawn1YK8Mshe4Ln";
    private Connection connection;



    @Override
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void closeConnection() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PreparedStatement createPreparedStatement(String preparedSql)  {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            return connection.prepareStatement(preparedSql);

        } catch (SQLException throwables) {
            throwables.getMessage();
        }
        return preparedStatement;
    }

}
