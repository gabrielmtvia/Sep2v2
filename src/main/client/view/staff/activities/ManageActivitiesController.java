package main.client.view.staff.activities;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.client.core.ViewHandler;
import main.shared.Activity;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManageActivitiesController {

    @FXML private TableView<Activity> tableView;
    @FXML private TableColumn<Activity, String> time;
    @FXML private TableColumn<Activity, String> type ;
    @FXML private TableColumn<Activity, String> date ;
    @FXML private TableColumn<Activity, String> price ;
    @FXML private TextField typeField;
    @FXML private TextField priceField;
    @FXML private DatePicker datePicker;
    @FXML private TextField timeField;
    @FXML private TextField dateField;

    private ManageActivitiesViewModel manageActivitiesViewModel;

    private ViewHandler viewHandler;


    public void init(ManageActivitiesViewModel manageActivitiesViewModel, ViewHandler viewHandler)
    {
        this.manageActivitiesViewModel = manageActivitiesViewModel;
        this.viewHandler = viewHandler;

        manageActivitiesViewModel.typeFieldProperty().bindBidirectional(typeField.textProperty());
        manageActivitiesViewModel.priceFieldProperty().bindBidirectional(priceField.textProperty());
        manageActivitiesViewModel.timeProperty().bindBidirectional(timeField.textProperty());
        manageActivitiesViewModel.dateProperty().bind(datePicker.getEditor().textProperty());


        tableView.setItems(manageActivitiesViewModel.getItemsList());


        type.setCellValueFactory(new PropertyValueFactory<>("activityName"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        date.setCellValueFactory(new PropertyValueFactory<>("day"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));

    }


    public void date(){
        LocalDate startingDate = datePicker.getValue();
        System.out.println(startingDate);
    }



    public void backButton(ActionEvent actionEvent) {
        viewHandler.openStaffMain();
    }

    public void deleteButton() throws RemoteException {

        ObservableList<Integer> items = tableView.getSelectionModel().getSelectedIndices();

        Object[] array = items.toArray();
        //converting objects to number and assign to a position
        int position = (int) array[0];

        ArrayList<Activity> activities = manageActivitiesViewModel.requestActivities();

        Activity deletedActivity = activities.get(position);

        manageActivitiesViewModel.deleteAnActivity(deletedActivity);
        tableView.getItems().remove(position);

    }

    public void saveButton(ActionEvent actionEvent) throws RemoteException {
        manageActivitiesViewModel.saveActivity();
    }
}
