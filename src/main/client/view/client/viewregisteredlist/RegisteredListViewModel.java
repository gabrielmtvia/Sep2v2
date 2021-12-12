package main.client.view.client.viewregisteredlist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import main.client.model.activities.ActivitiesModel;
import main.client.model.login.LoginModel;
import main.shared.Activity;

public class RegisteredListViewModel
{
    private ActivitiesModel activitiesManager;
    private LoginModel loginManager;
    private ObservableList<Activity> items;

    public RegisteredListViewModel(ActivitiesModel activitiesManager, LoginModel loginManager)
    {
        this.loginManager = loginManager;
        this.activitiesManager = activitiesManager;

        items = FXCollections.observableArrayList();
        items.addAll(activitiesManager.requestRegisteredActivities());
    }

    public ObservableList<Activity> getItems()
    {
        return items;
    }

    public void cancelRegistration(Activity activity)
    {
        String response = activitiesManager.cancelRegistration(activity, loginManager.getUserName());

        items.clear();
        items.addAll(activitiesManager.requestRegisteredActivities());

        if(response.contains("resultado")){
            response = "Registration cancelled successfully";
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cancel operation");
        alert.setContentText(response);
        alert.showAndWait();
    }
}
