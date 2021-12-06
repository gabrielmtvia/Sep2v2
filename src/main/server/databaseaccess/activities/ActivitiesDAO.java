package main.server.databaseaccess.activities;

import main.server.databaseaccess.database.DBConnectionModel;
import main.shared.Activity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                Activity activity = new Activity(resultSet.getString("activityname"),resultSet.getString("price"),resultSet.getString("date"),resultSet.getString("time"));
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
    public void deleteActivity(Activity activity) {

    }

    @Override
    public String saveActivity(Activity activity) {
        PreparedStatement statement;

        try {
            String query = "INSERT INTO activities (activityName, price, date, time) VALUES (?,?,?,?)";
            statement = dbConnection.createPreparedStatement(query);
            statement.setString(1, activity.getActivityName());
            statement.setString(2, activity.getPrice());
            statement.setString(3, activity.getDate());
            statement.setString(4, activity.getTime());
            statement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            dbConnection.closeConnection();
        }

        return "Activity saved successfully";
    }


}
