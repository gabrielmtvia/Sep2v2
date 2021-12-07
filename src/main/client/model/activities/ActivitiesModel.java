package main.client.model.activities;

import main.shared.Activity;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface ActivitiesModel {
    ArrayList<Activity> requestActivities();
    String deleteActivity(Activity activity);
    String saveActivity(Activity activity);
    void addListener(String eventName, PropertyChangeListener listener);
}
