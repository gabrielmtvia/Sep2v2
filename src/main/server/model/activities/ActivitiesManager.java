package main.server.model.activities;

import main.server.persistence.activities.ActivitiesDAOModel;
import main.shared.Activity;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ActivitiesManager implements ActivitiesModel {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private ActivitiesDAOModel activitiesDAO;

    public ActivitiesManager(ActivitiesDAOModel activitiesDAO){
        this.activitiesDAO = activitiesDAO;
    }

    @Override
    public ArrayList<Activity> requestActivities() {
        return activitiesDAO.requestActivities();
    }

    @Override
    public void deleteActivity(Activity activity) {
        activitiesDAO.deleteActivity(activity);
    }

    @Override
    public String saveActivity(Activity activity) {
        return activitiesDAO.saveActivity(activity);
    }

}
