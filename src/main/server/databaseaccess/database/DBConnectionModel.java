package main.server.databaseaccess.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface DBConnectionModel {

    void closeConnection();
    PreparedStatement createPreparedStatement(String preparedSql) throws Exception;
    Connection getConnection();
}
