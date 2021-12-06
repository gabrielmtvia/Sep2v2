package main.server.persistence.activities;

import main.shared.Activity;

import java.util.ArrayList;

public interface ActivitiesDAOModel {
    ArrayList<Activity> requestActivities();
    void deleteActivity(Activity activity);
    String saveActivity(Activity activity);
}