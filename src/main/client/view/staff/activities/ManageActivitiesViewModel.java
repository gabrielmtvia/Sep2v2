package main.client.view.staff.activities;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.util.converter.LocalDateStringConverter;
import main.client.model.activities.ActivitiesModel;
import main.shared.Activity;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManageActivitiesViewModel {


    private StringProperty type;
    private StringProperty price;
    private StringProperty time;

    private ActivitiesModel activitiesManager;

    private ObservableList<Activity> items;


    private StringProperty date;


    public ManageActivitiesViewModel(ActivitiesModel activitiesManager) {
        this.activitiesManager = activitiesManager;
        items = FXCollections.observableArrayList();

        date = new SimpleStringProperty();
        type = new SimpleStringProperty();
        price = new SimpleStringProperty();
        time = new SimpleStringProperty();
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

        String dates = date.getValue();
        String[] dateSplit = dates.split("/");
        String day = dateSplit[0];
        String month = dateSplit[1];
        String year = dateSplit[2];
        String dbFormat = year+"-"+month+"-"+day;

        Activity activity = new Activity(type.getValue(),time.getValue(),price.getValue(),dbFormat,"dummy", "dummy");
        String result = activitiesManager.saveActivity(activity);
        type.setValue("");
        price.setValue("");
        time.setValue("");

        alert(result);

        System.out.println(result);
        System.out.println(date.getValue());
        System.out.println(dbFormat);

    }

    public void alert(String response){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText(response);
        alert.showAndWait();
    }

    public ArrayList<Activity> requestActivities() {
        return  activitiesManager.requestActivities();
    }


    public void deleteAnActivity(Activity activity) {
        String response = activitiesManager.deleteActivity(activity);
        alert(response);
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


}
