package main.client.model.activities;

import main.shared.Activity;
import main.shared.UserName;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface ActivitiesModel
{
    ArrayList<Activity> requestActivities();
    String deleteActivity(Activity activity);
    String saveActivity(Activity activity);
    String registerActivities(Activity activity, UserName userName);
    void addListener(String eventName, PropertyChangeListener listener);
    ArrayList<Activity> requestRegisteredActivities(UserName userName);
    String cancelRegistration(Activity activity, UserName userName);
}
