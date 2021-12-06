package main.client.view.staff.activities;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.client.model.activities.ActivitiesModel;
import main.shared.Activity;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ManageActivitiesViewModel {


    private StringProperty type;
    private StringProperty price;
    private StringProperty time;
    private StringProperty date;

    private ActivitiesModel activitiesManager;

    private ObservableList<Activity> items;


    //private ObjectProperty<LocalDate> date;


    public ManageActivitiesViewModel(ActivitiesModel activitiesManager) {
        this.activitiesManager = activitiesManager;
        items = FXCollections.observableArrayList();

        //date = new SimpleObjectProperty<>();
        date = new SimpleStringProperty();
        type = new SimpleStringProperty();
        price = new SimpleStringProperty();
        time = new SimpleStringProperty();
        //model.addListener("addingActivity", evt -> updatedTable(evt));
        items.addAll(activitiesManager.requestActivities());

        activitiesManager.addListener("Activity Deleted", evt -> activityDeleted(evt));
        activitiesManager.addListener("Activity Added", evt -> activityAdded(evt));

    }

    private void activityAdded(PropertyChangeEvent evt) {
        Activity activityAdded = (Activity) evt.getNewValue();
        items.add(activityAdded);
    }

    private void activityDeleted(PropertyChangeEvent evt) {
        Activity activityDeleted = (Activity) evt.getNewValue();
        items.remove(activityDeleted);
    }


    public void saveActivity() throws RemoteException {

        Activity activity = new Activity(type.getValue(), price.getValue(), date.getValue(), time.getValue());
        activitiesManager.saveActivity(activity);
        type.setValue("");
        price.setValue("");
        date.setValue("");
        time.setValue("");

    }

    public ArrayList<Activity> requestActivities() throws RemoteException {
        return  activitiesManager.requestActivities();
    }


    public void deleteAnActivity(Activity activity) throws RemoteException {

        activitiesManager.deleteActivity(activity);

    }

    public StringProperty dateProperty() {
        return date;
    }

    public StringProperty typeFieldProperty() {
        return type;
    }


    public StringProperty priceFieldProperty() {
        return price;
    }


    public StringProperty timeProperty() {
        return time;
    }

    public ObservableList<Activity> getItemsList() {
        return items;
    }



/*
    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

 */
}
