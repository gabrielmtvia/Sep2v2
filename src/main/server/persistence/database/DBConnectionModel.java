package main.server.persistence.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface DBConnectionModel {

    void closeConnection();
    PreparedStatement createPreparedStatement(String preparedSql) throws Exception;
    Connection getConnection();
}
