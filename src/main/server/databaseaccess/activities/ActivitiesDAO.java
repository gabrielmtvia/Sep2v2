package main.server.databaseaccess.activities;

import main.server.databaseaccess.database.DBConnectionModel;
import main.shared.Activity;

import java.sql.*;
import java.util.ArrayList;

public class ActivitiesDAO implements ActivitiesDAOModel{

    private DBConnectionModel dbConnection;

    public ActivitiesDAO(DBConnectionModel dbConnection){
        this.dbConnection = dbConnection;
    }

    @Override
    public ArrayList<Activity> requestActivities() {
        PreparedStatement statement;
        ResultSet resultSet;
        ArrayList<Activity> list = new ArrayList<>();
        try {
            String query ="SELECT * FROM activities";
            statement = dbConnection.createPreparedStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                //Activity activity = new Activity(resultSet.getString("type"),resultSet.getString("price"),resultSet.getString("date"),resultSet.getString("startTime"),resultSet.getString("endTime"));
                Activity activity = new Activity(resultSet.getString("type"),resultSet.getString("price"),resultSet.getString("date"),resultSet.getString("startTime"),resultSet.getString("endTime"));
                list.add(activity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }

        return list;
    }

    @Override
    public String deleteActivity(Activity activity) {
        PreparedStatement statement;
        try
        {
            String query = " DELETE FROM activities WHERE type = ?";
            statement =dbConnection.createPreparedStatement(query);
            statement.setString(1, activity.getActivityName());
            statement.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Activity deleted successfully";
    }

    @Override
    public String saveActivity(Activity activity) {
        PreparedStatement statement;

        try {
            String query = "INSERT INTO activities (type, price, date, starttime, endtime) VALUES (?,?,?,?,?)";
            statement = dbConnection.createPreparedStatement(query);
            statement.setString(1, activity.getActivityName());
            statement.setString(2,  activity.getPrice());
            statement.setDate(3,    Date.valueOf(activity.getDate()));
            statement.setString(4,  activity.getStartTime());
            statement.setString(5, activity.getEndTime());
            statement.executeQuery();


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            dbConnection.closeConnection();
        }

        return "Activity saved successfully";
    }


}
