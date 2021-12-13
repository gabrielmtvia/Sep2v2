package main.client.view.client.activities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import main.client.model.activities.ActivitiesModel;
import main.client.model.login.LoginModel;
import main.shared.Activity;
import main.shared.UserName;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class ActivitiesViewModel
{
    private ActivitiesModel activitiesManager;
    private LoginModel loginManager;
    private UserName userName;
    private ObservableList<Activity> items;

    public ActivitiesViewModel(ActivitiesModel activitiesManager, LoginModel loginManager)
    {
        this.activitiesManager = activitiesManager;
        this.loginManager = loginManager;
        userName = loginManager.getUserName();

        items = FXCollections.observableArrayList();
        activitiesManager.addListener("Activity Deleted", evt -> activityDeleted(evt));
        activitiesManager.addListener("Activity Added", evt -> activityAdded(evt));

        loadActivities();
    }

    private void activityAdded(PropertyChangeEvent evt)
    {
        Activity activityAdded = (Activity) evt.getNewValue();
        items.add(activityAdded);
    }

    private void activityDeleted(PropertyChangeEvent evt)
    {
        Activity activityDeleted = (Activity) evt.getNewValue();
        items.remove(activityDeleted);
    }

    public ArrayList<Activity> requestActivities()
    {
        return  activitiesManager.requestActivities();
    }


    public ObservableList<Activity> getItemsList()
    {
        return items;
    }

    public void registerActivity(Activity activity)
    {
        String response = activitiesManager.registerActivities(activity,userName);
        if(response.contains("duplicate")){
            response = "Error. Activity already registered";
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registration");
        alert.setContentText(response);
        alert.showAndWait();
    }

    public void loadActivities()
    {
        items.addAll(activitiesManager.requestActivities());
    }
}


