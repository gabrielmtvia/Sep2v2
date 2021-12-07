package main.client.view.client.activities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.client.core.ViewHandler;
import main.shared.Activity;


public class ActivitiesController {
    @FXML
    private TableView<Activity> tableView;

    @FXML private TableColumn<Activity, String> time;
    @FXML private TableColumn<Activity, String> type ;
    @FXML private TableColumn<Activity, String> date ;
    @FXML private TableColumn<Activity, String> price ;


    private ViewHandler viewHandler;
    private ActivitiesViewModel activitiesViewModel;


    public void init(ActivitiesViewModel activitiesViewModel, ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        this.activitiesViewModel = activitiesViewModel;
        type.setCellValueFactory(new PropertyValueFactory<>("activityName"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        date.setCellValueFactory(new PropertyValueFactory<>("day") );

        activitiesViewModel.loadActivities();
        tableView.setItems(activitiesViewModel.getItemsList());

    }

    public void backButton(ActionEvent actionEvent) {
        viewHandler.openClientMain();
    }

    public void saveButton(ActionEvent actionEvent) {
    }
}
