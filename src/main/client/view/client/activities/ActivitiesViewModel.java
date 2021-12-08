package main.client.view.client.activities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.client.model.activities.ActivitiesModel;
import main.shared.Activity;

import java.beans.PropertyChangeEvent;


public class ActivitiesViewModel {


    private ActivitiesModel activitiesManager;

    private ObservableList<Activity> items;

    public ActivitiesViewModel(ActivitiesModel activitiesManager){
        this.activitiesManager = activitiesManager;
        items = FXCollections.observableArrayList();
        activitiesManager.addListener("Activity Deleted", evt -> activityDeleted(evt));
        activitiesManager.addListener("Activity Added", evt -> activityAdded(evt));

        loadActivities();
    }

    private void activityAdded(PropertyChangeEvent evt) {
        Activity activityAdded = (Activity) evt.getNewValue();
        items.add(activityAdded);
    }

    private void activityDeleted(PropertyChangeEvent evt) {
        Activity activityDeleted = (Activity) evt.getNewValue();
        items.remove(activityDeleted);
    }


    public ObservableList<Activity> getItemsList() {
        return items;
    }

    public void loadActivities() {
        items.addAll(activitiesManager.requestActivities());
    }
}


