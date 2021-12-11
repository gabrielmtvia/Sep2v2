package main.client.view.client.viewregisteredlist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.client.model.activities.ActivitiesModel;
import main.shared.Activity;

public class RegisteredListViewModel {



    private ActivitiesModel activitiesManager;
    private ObservableList<Activity> items;




    public RegisteredListViewModel(ActivitiesModel activitiesManager){
        this.activitiesManager = activitiesManager;

        items = FXCollections.observableArrayList();


        items.addAll( activitiesManager.requestRegisteredActivities());


    }

    public ObservableList<Activity> getItems() {
        return items;
    }


}
