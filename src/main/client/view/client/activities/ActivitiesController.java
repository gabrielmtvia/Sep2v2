package main.client.view.client.activities;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.client.core.ViewHandler;
import main.shared.Activity;

import java.util.ArrayList;


public class ActivitiesController {
    @FXML private  TableColumn date;
    @FXML private  TableColumn startTime;
    @FXML private  TableColumn endTime;
    @FXML private  TableColumn activityName;
    @FXML private  TableColumn price;
    @FXML private TableView<Activity> tableView;


    private ViewHandler viewHandler;
    private ActivitiesViewModel activitiesViewModel;


    public void init(ActivitiesViewModel activitiesViewModel, ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        this.activitiesViewModel = activitiesViewModel;

        date.setCellValueFactory(new PropertyValueFactory<>("activityName"));
        startTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endTime.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        activityName.setCellValueFactory(new PropertyValueFactory<>("activityName"));
        price.setCellValueFactory(new PropertyValueFactory<>("price") );

        tableView.setItems(activitiesViewModel.getItemsList());
    }

    public void backButton(ActionEvent actionEvent) {
        viewHandler.openClientMain();
    }

    public void alert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText("Need to implement this feature");
        alert.showAndWait();
    }
    public void saveButton() {

        //converting the selected row to int (index)

        ObservableList<Integer> items = tableView.getSelectionModel().getSelectedIndices();

        //getting the all array elements (int) in order to wrap in Object[]
        Object[] array = items.toArray();
        //getting index of that element  and assign to a position after casting to (int)
        int position = (int) array[0];
        //getting all requested requestedActivities from database wrap them in an array
        ArrayList<Activity> activities = activitiesViewModel.requestActivities();

        //get the activity by position
        Activity registerActivity = activities.get(position);

    }
}
