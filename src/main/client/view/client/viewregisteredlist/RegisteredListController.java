package main.client.view.client.viewregisteredlist;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.client.core.ViewHandler;
import main.shared.Activity;
import main.shared.PersonalTrainer;

public class RegisteredListController {

    private ViewHandler viewHandler;
    private RegisteredListViewModel registeredListViewModel;
    @FXML
    private TableColumn date;
    @FXML private  TableColumn startTime;
    @FXML private  TableColumn endTime;
    @FXML private  TableColumn activityName;
    @FXML private  TableColumn price;
    @FXML private TableView<Activity> tableView;

    public void init(RegisteredListViewModel registeredListViewModel, ViewHandler viewHandler){
        this.registeredListViewModel = registeredListViewModel;
        this.viewHandler = viewHandler;

        activityName.setCellValueFactory(new PropertyValueFactory<>("activityName"));
        price.setCellValueFactory(new PropertyValueFactory<>("price") );
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        startTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endTime.setCellValueFactory(new PropertyValueFactory<>("endTime"));



       tableView.setItems(registeredListViewModel.getItems());


    }

    public void backButton() {
        viewHandler.openClientActivities();
    }


    public void cancelButton(ActionEvent actionEvent) {

        ObservableList<Integer> observableList = tableView.getSelectionModel().getSelectedIndices();
        Object[] array = observableList.toArray();
        int position = (int) array[0];

        ObservableList<Activity> activities = registeredListViewModel.getItems();
        Activity activity = activities.get(position);

        registeredListViewModel.cancelRegistration(activity);
    }
}
