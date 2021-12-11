package main.server.databaseaccess.activities;

import main.server.databaseaccess.database.DBConnectionModel;
import main.shared.Activity;
import main.shared.UserName;

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
        ResultSet resultSet;
        try
        {
           // String query0 = "DELETE from registrations where registrations.activityno = activities.activityno";
            //todo


            String query = "select activityno from activities where type like ? ";
            statement =dbConnection.createPreparedStatement(query);
            statement.setString(1, activity.getActivityName());

            resultSet = statement.executeQuery();

            int activityNumber = 0;

            while (resultSet.next()){
                activityNumber = resultSet.getInt("activityno");

            }


            String query1 = " DELETE FROM activities WHERE activityno = ?";

            statement =dbConnection.createPreparedStatement(query1);
            statement.setInt(1, activityNumber);

             statement.executeQuery();





        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "Activity deleted successfully";



/*
        PreparedStatement statement;
        PreparedStatement statement1;
        ResultSet resultSet;

        try
        {
            // String query0 = "DELETE from registrations where registrations.activityno = activities.activityno";
            String query = "select activityno from activities where type like ? ";
            statement =dbConnection.createPreparedStatement(query);
            statement.setString(1, activity.getActivityName());

            resultSet = statement.executeQuery();

            int activityNumber = 0;

            while (resultSet.next()){
                activityNumber = resultSet.getInt("activityno");

            }

            String query1 = "DELETE FROM registrations WHERE activityno = ?";
            statement = dbConnection.createPreparedStatement(query1);

            statement.setInt(1,activityNumber);
            statement.executeQuery();




            int activityNumber2 = 0;
            while (resultSet.next()){
                activityNumber2 = resultSet.getInt("activityno");

            }

            String query2 = "DELETE from activities where activityno = ? ";
            statement = dbConnection.createPreparedStatement(query2);
            statement.setInt(2, activityNumber2);
            statement.executeQuery();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }


        return "Activity deleted successfully";
 */











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


    @Override
    public String registerActivities(Activity activity, UserName userName) {
        PreparedStatement statement;
        ResultSet resultSet;


        try {
            String query = "select * from activities where type like ? and price like ? and date = ?   ";
            statement = dbConnection.createPreparedStatement(query);

            statement.setString(1, activity.getActivityName() );
            statement.setString(2, activity.getPrice());
            statement.setDate(3, Date.valueOf(activity.getDate()));


            resultSet = statement.executeQuery();
            int activityNumber = 0;
            while (resultSet.next()){
                 activityNumber = resultSet.getInt("activityno");

            }

            String query2 = "insert into registrations values (?,?) ;";
            statement = dbConnection.createPreparedStatement(query2);
            statement.setString(1, userName.getUserName());

            statement.setInt(2, activityNumber );

            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            dbConnection.closeConnection();
        }







        return "Activity has been registered successfully";




    }

    @Override
    public ArrayList<Activity> requestRegisteredActivities() {
        PreparedStatement statement;
        ResultSet resultSet;

        ArrayList<Activity> list = new ArrayList<>();
        try {
            String query ="SELECT activities.type, price, date, starttime, endtime from activities join registrations on activities.activityno = registrations.activityno";
            statement = dbConnection.createPreparedStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
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


}
