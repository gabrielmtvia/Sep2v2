package main.client.view.staff.activities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.client.core.ViewHandler;
import main.shared.Activity;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ManageActivitiesController {





    @FXML private TableView<Activity> tableView;

    @FXML private TableColumn<Activity, String> type ;
    @FXML private TableColumn<Activity, String> date ;
    @FXML private TableColumn<Activity, String> price ;
    @FXML private TableColumn<Activity, String> startTime;
    @FXML private TableColumn<Activity, String> endTime;


    @FXML private ComboBox<String> selectTypeBox = new ComboBox<>();
    @FXML private TextField startTimeField;
    @FXML private TextField endTimeField;
    @FXML private TextField priceField;


    @FXML private DatePicker datePicker;



    private ManageActivitiesViewModel manageActivitiesViewModel;

    private ViewHandler viewHandler;


    public void init(ManageActivitiesViewModel manageActivitiesViewModel, ViewHandler viewHandler)
    {





        selectTypeBox.setItems( FXCollections.observableArrayList("Squat","Stretching","Balance exercises", "Yoga", "Running", "Jumping"));



        this.manageActivitiesViewModel = manageActivitiesViewModel;
        this.viewHandler = viewHandler;

        manageActivitiesViewModel.typeFieldProperty().bindBidirectional(selectTypeBox.valueProperty());
        manageActivitiesViewModel.priceFieldProperty().bindBidirectional(priceField.textProperty());

        manageActivitiesViewModel.startTimeFieldProperty().bindBidirectional(startTimeField.textProperty());
        manageActivitiesViewModel.endTimeFieldProperty().bindBidirectional(endTimeField.textProperty());





        manageActivitiesViewModel.dateProperty().bind(datePicker.getEditor().textProperty());



        tableView.setItems(manageActivitiesViewModel.getItemsList());


        type.setCellValueFactory(new PropertyValueFactory<>("activityName"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        startTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endTime.setCellValueFactory(new PropertyValueFactory<>("endTime"));

    }






    public void backButton() {
        viewHandler.openStaffMain();
    }

    public void deleteButton() throws RemoteException {
        //converting the selected row to int (index)

        ObservableList<Integer> items = tableView.getSelectionModel().getSelectedIndices();

        //getting the all array elements (int) in order to wrap in Object[]
        Object[] array = items.toArray();
        //getting index of that element  and assign to a position after casting to (int)
        int position = (int) array[0];
        //getting all requested requestedActivities from database wrap them in an array
        ArrayList<Activity> activities = manageActivitiesViewModel.requestActivities();
        //we target the position of the selected activity
        Activity deletedActivity = activities.get(position);
        // call deleting
        manageActivitiesViewModel.deleteAnActivity(deletedActivity);
        //finally removing
        tableView.getItems().remove(position);

    }

    public void saveButton(ActionEvent actionEvent) throws RemoteException {
        manageActivitiesViewModel.saveActivity();
    }
}
