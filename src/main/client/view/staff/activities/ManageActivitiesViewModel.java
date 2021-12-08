package main.client.view.staff.activities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import main.client.model.activities.ActivitiesModel;
import main.shared.Activity;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

public class ManageActivitiesViewModel {

    private StringProperty date;
    private StringProperty type;
    private StringProperty price;
    private StringProperty startTimeField;
    private StringProperty endTimeField;

    private StringProperty response;


    private ActivitiesModel activitiesManager;
    private ObservableList<Activity> items;



    public ManageActivitiesViewModel(ActivitiesModel activitiesManager) {
        this.activitiesManager = activitiesManager;
        items = FXCollections.observableArrayList();

        startTimeField = new SimpleStringProperty();
        endTimeField = new SimpleStringProperty();

        response = new SimpleStringProperty();

        date = new SimpleStringProperty();
        type = new SimpleStringProperty();
        price = new SimpleStringProperty();

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



    public StringProperty responseProperty() {
        return response;
    }

    public void saveActivity() {

        String[] dateSplit = date.getValue().split("/");
        String day = dateSplit[0];
        String month = dateSplit[1];
        String year = dateSplit[2];
        String dbFormat = year+"-"+month+"-"+day;

        String[] timeSplit = null;


        try{
            timeSplit = startTimeField.getValue().split(":");
            Integer.parseInt(timeSplit[0]);
            Integer.parseInt(timeSplit[1]);

        }catch (PatternSyntaxException e){
            alert(e.getMessage());
          //  alert("incorrect time format");

        }

        System.out.println("the time is " + " "+ Integer.parseInt(timeSplit[0])+ " hours and " + Integer.parseInt(timeSplit[1]) + " minutes");








        //String response = "Please fill the date in HH:MM format";
        //alert(response);

        boolean isValid = true;
        StringBuilder infoMessage = new StringBuilder();
        Integer priceField = 0;
        Integer startTimeHours = 0;
        Integer startTimeMinutes = 0;
        Integer endTimeHours = 0;
        Integer endTimeMinutes = 0;

        try{
            priceField = Integer.parseInt(price.getValue());
/*
            Integer startTimeHours = 0;
            Integer startTimeMinutes = 0;
            Integer endTimeHours = 0;
            Integer endTimeMinutes = 0;

 */

        }catch (Exception e){
            infoMessage.append(e.getMessage());
            isValid = false;
        }


        if(isValid)
        {
                if (priceField<=500 && priceField>=50)
                {
                    Activity activity = new Activity(type.getValue(),price.getValue(),dbFormat,startTimeField.getValue(),endTimeField.getValue());
                    String result = activitiesManager.saveActivity(activity);
                    type.setValue("");
                    price.setValue("");
                    startTimeField.setValue("");
                    endTimeField.setValue("");

                    alert(result);

                    System.out.println(result);
                    System.out.println(date.getValue());
                    System.out.println(dbFormat);

                }else {
                    alert("put the correct value");
                }

        }
        else
        {
            alert(infoMessage.toString());
        }











           /* if (startTimeField.getValue()!= null && endTimeFieldProperty() != null){


            }else {
                alert("add correct Time");
                // response.setValue("add correct Time");
            }


        }

         else {
            alert("The price could not be null or more than 4 integer");
            alert("Please add a price no more than 500 ");
            //response.setValue("value could not be negative ");
        }

         */





/*
        if (timeSplit.length != 0 || timeSplit.length != 1){


        }
        else {

        }

 */



}








           /* int price = 0;
            price = Integer.parseInt(String.valueOf(price));

            */
        //price.get().length() > 0 && price.get().length() < 4




/*
        Activity activity = new Activity(type.getValue(), price.getValue(),dbFormat,startTimeField.getValue(),endTimeField.getValue());
        String result = activitiesManager.saveActivity(activity);
        type.setValue("");
        price.setValue("");
        startTimeField.setValue("");
        endTimeField.setValue("");

        alert(result);

        System.out.println(result);
        System.out.println(date.getValue());
        System.out.println(dbFormat);


 */






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

    public StringProperty startTimeFieldProperty() {
        return startTimeField;
    }


    public StringProperty endTimeFieldProperty() {
        return endTimeField;
    }




    public ObservableList<Activity> getItemsList() {
        return items;
    }



}
