package main.client.view.client.viewregisteredlist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import main.client.model.activities.ActivitiesModel;
import main.client.model.login.LoginModel;
import main.shared.Activity;

import java.beans.PropertyChangeEvent;

public class RegisteredListViewModel {



    private ActivitiesModel activitiesManager;
    private LoginModel loginManager;
    private ObservableList<Activity> items;




    public RegisteredListViewModel(ActivitiesModel activitiesManager, LoginModel loginManager){
        this.loginManager = loginManager;
        this.activitiesManager = activitiesManager;

        items = FXCollections.observableArrayList();
        items.addAll(activitiesManager.requestRegisteredActivities(loginManager.getUserName()));

        activitiesManager.addListener("Activity Registered", evt -> activityRegistered(evt));

    }

    private void activityRegistered(PropertyChangeEvent evt) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            items.clear();
            items.addAll(activitiesManager.requestRegisteredActivities(loginManager.getUserName()));
        }).start();

    }

    public ObservableList<Activity> getItems() {
        return items;
    }


    public void cancelRegistration(Activity activity) {
        String response = activitiesManager.cancelRegistration(activity, loginManager.getUserName());

        items.clear();
        items.addAll(activitiesManager.requestRegisteredActivities(loginManager.getUserName()));

        if(response.contains("resultado")){
            response = "Registration cancelled successfully";
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cancel operation");
        alert.setContentText(response);
        alert.showAndWait();
    }
}
