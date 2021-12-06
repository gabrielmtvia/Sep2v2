package main.server.databaseaccess.activities;

import main.shared.Activity;

import java.util.ArrayList;

public interface ActivitiesDAOModel {
    ArrayList<Activity> requestActivities();
    String deleteActivity(Activity activity);
    String saveActivity(Activity activity);
}
