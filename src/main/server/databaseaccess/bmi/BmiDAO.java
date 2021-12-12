package main.server.databaseaccess.bmi;

import main.server.databaseaccess.database.DBConnectionModel;
import main.shared.BMIData;
import main.shared.UserName;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BmiDAO implements BmiDAOModel
{
    private DBConnectionModel dbConnection;

    public BmiDAO(DBConnectionModel dbConnection)
    {
        this.dbConnection = dbConnection;
    }

    @Override
    public String saveBmiData(BMIData bmiData)
    {
        double height = bmiData.getHeight();
        double weight = bmiData.getWeight();
        String username = bmiData.getUserName();

        System.out.println(bmiData);

        PreparedStatement statement;

        try {
            String query = "update clients set weight=? where username=?";
            statement = dbConnection.createPreparedStatement(query);
            statement.setDouble(1, weight);
            statement.setString(2, username);
            statement.executeQuery();


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            dbConnection.closeConnection();
        }

        try {
            String query = "update clients set height=? where username=?";
            statement = dbConnection.createPreparedStatement(query);
            statement.setDouble(1, height);
            statement.setString(2, username);
            statement.executeQuery();


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            dbConnection.closeConnection();
        }

        return "BMI Data saved successfully";

    }

    @Override
    public BMIData loadBmiData(UserName userName)
    {
        String username = userName.getUserName();
        PreparedStatement statement;
        ResultSet resultSet;

        BMIData bmiData = new BMIData(0,0);

        try {
            String query = "select * from clients where username=?";
            statement = dbConnection.createPreparedStatement(query);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                bmiData = new BMIData(resultSet.getDouble("weight"), resultSet.getDouble("height"));
            }


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            dbConnection.closeConnection();
        }

        return bmiData;
    }

    @Override
    public String deleteBmiData(UserName userName)
    {
        String username = userName.getUserName();

        PreparedStatement statement;

        try {
            String query = "update clients set weight=? where username=?";
            statement = dbConnection.createPreparedStatement(query);
            statement.setDouble(1, 0);
            statement.setString(2, username);
            statement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            dbConnection.closeConnection();
        }

        try {
            String query = "update clients set height=? where username=?";
            statement = dbConnection.createPreparedStatement(query);
            statement.setDouble(1, 0);
            statement.setString(2, username);
            statement.executeQuery();


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            dbConnection.closeConnection();
        }
        return "BMI Data deleted successfully";
    }
}
