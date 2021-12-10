package main.server.databaseaccess.activities;

import main.shared.Activity;
import main.shared.UserName;

import java.util.ArrayList;

public interface ActivitiesDAOModel {
    ArrayList<Activity> requestActivities();
    String deleteActivity(Activity activity);
    String saveActivity(Activity activity);
    String registerActivities(Activity activity, UserName userName);
    ArrayList<Activity> requestRegisteredActivities();
}
