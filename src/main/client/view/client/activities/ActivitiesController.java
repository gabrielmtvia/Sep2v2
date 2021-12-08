package main.client.view.client.activities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.client.core.ViewHandler;
import main.shared.Activity;


public class ActivitiesController {
    @FXML private  TableColumn date;
    @FXML private  TableColumn startTime;
    @FXML private  TableColumn endTime;
    @FXML private  TableColumn activityName;
    @FXML private  TableColumn price;
    @FXML
    private TableView<Activity> tableView;




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

    public void saveButton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText("Need to implement this feature");
        alert.showAndWait();
    }
}
