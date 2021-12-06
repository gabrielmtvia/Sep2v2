package main.server.persistence.login;

import main.server.persistence.database.DBConnectionModel;
import main.shared.Password;
import main.shared.UserName;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO implements LoginDAOModel{

    private DBConnectionModel dbConnection;

    public LoginDAO(DBConnectionModel dbConnection){
        this.dbConnection = dbConnection;
    }

    @Override
    public String validateLoginClient(UserName userName, Password password) {
        PreparedStatement statement;
        ResultSet resultSet;
        String result = "Failed connection to the database";
        try {
            String query ="SELECT * FROM customer WHERE username = ?";
            statement = dbConnection.createPreparedStatement(query);
            statement.setString(1, userName.getUserName());
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                String passwordDB = resultSet.getString("password");
                if(passwordDB.equals(password.getPassword())){
                    result = "Client Login Successfully";
                } else {
                    result = "Wrong Credentials";
                }
            } else {
                result = "Username does not exist";
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }

        return result;
    }
}
