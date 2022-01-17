package main.client.networking.activities;

import main.client.networking.rmi.RemoteClient;
import main.shared.Activity;
import main.shared.UserName;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ActivitiesClient implements ActivitiesClientModel {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private RemoteClient rmiClient;

    public ActivitiesClient(RemoteClient rmiClient){
        this.rmiClient = rmiClient;
        try {
            rmiClient.addListener("Activity Deleted", evt -> activityDeleted(evt));
            rmiClient.addListener("Activity Added", evt -> activityAdded(evt));
            rmiClient.addListener("Activity Registered", evt -> activityRegistered(evt));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void activityRegistered(PropertyChangeEvent evt) {
        support.firePropertyChange("Activity Registered", null, "Activity Registered");
    }

    private void activityAdded(PropertyChangeEvent evt) {
        Activity activity = (Activity) evt.getNewValue();
        support.firePropertyChange("Activity Added", null, activity);

    }

    private void activityDeleted(PropertyChangeEvent evt) {
        Activity activity = (Activity) evt.getNewValue();
        support.firePropertyChange("Activity Deleted", null, activity);
    }

    @Override
    public ArrayList<Activity> requestActivities() {
        try {
            return rmiClient.requestActivities();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteActivity(Activity activity) {
        try {
            return rmiClient.deleteActivity(activity);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Connection Lost";
        }

    }

    @Override
    public String saveActivity(Activity activity) {
        try {
            return rmiClient.saveActivity(activity);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Connection Lost";
        }

    }

    @Override
    public String registerActivities(Activity activity, UserName userName)  {
        try {
            return rmiClient.registerActivities(activity, userName);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Connection Lost";
        }

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
    public ArrayList<Activity> requestRegisteredActivities(UserName userName) {

        try {
            return rmiClient.requestRegisteredActivities(userName);
        } catch (RemoteException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public String cancelRegistration(Activity activity, UserName userName) {
        try {
            return rmiClient.cancelRegistration(activity, userName);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "Connection Lost";
        }
    }


}
