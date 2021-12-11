package main.client.model.activities;

import main.client.networking.activities.ActivitiesClientModel;
import main.shared.Activity;
import main.shared.UserName;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ActivitiesManager implements ActivitiesModel{

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    private ActivitiesClientModel activitiesClient;

    public ActivitiesManager(ActivitiesClientModel activitiesClient){
        this.activitiesClient = activitiesClient;
        activitiesClient.addListener("Activity Deleted", evt -> activityDeleted(evt));
        activitiesClient.addListener("Activity Added", evt -> activityAdded(evt));
    }

    private void activityAdded(PropertyChangeEvent evt) {
        Activity activity = (Activity) evt.getNewValue();

        support.firePropertyChange("Activity Added", null, activity);
    }

    private void activityDeleted(PropertyChangeEvent evt) {
        Activity activity = (Activity) evt.getNewValue();
        System.out.println(activity);

        support.firePropertyChange("Activity Deleted", null, activity);
    }


    @Override
    public ArrayList<Activity> requestActivities() {
        return activitiesClient.requestActivities();
    }

    @Override
    public String deleteActivity(Activity activity) {
        return activitiesClient.deleteActivity(activity);
    }

    @Override
    public String saveActivity(Activity activity) {
        return activitiesClient.saveActivity(activity);
    }

    @Override
    public String registerActivities(Activity activity, UserName userName) {
        return activitiesClient.registerActivities(activity, userName);
    }


    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)) {
            support.addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(eventName, listener);
        }
    }

    @Override
    public ArrayList<Activity> requestRegisteredActivities() {
        return activitiesClient.requestRegisteredActivities();
    }

    @Override
    public String cancelRegistration(Activity activity, UserName userName) {

        return activitiesClient.cancelRegistration(activity,userName);
    }
}
