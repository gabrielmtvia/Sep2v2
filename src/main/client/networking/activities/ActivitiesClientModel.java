package main.client.networking.activities;

import main.shared.Activity;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface ActivitiesClientModel {
    ArrayList<Activity> requestActivities();
    void deleteActivity(Activity activity);
    String saveActivity(Activity activity);
    void addListener(String eventName, PropertyChangeListener listener);
}
