package main.client.view.client.activities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.client.model.activities.ActivitiesModel;
import main.client.model.login.LoginModel;
import main.shared.Activity;



public class ActivitiesViewModel {


    private ActivitiesModel activitiesManager;

    private ObservableList<Activity> items;

    public ActivitiesViewModel(ActivitiesModel activitiesManager){
        this.activitiesManager = activitiesManager;
        items = FXCollections.observableArrayList();
    }

    public ObservableList<Activity> getItemsList() {
        return items;
    }



    public void loadActivities() {
        items.addAll(activitiesManager.requestActivities());
    }
}


