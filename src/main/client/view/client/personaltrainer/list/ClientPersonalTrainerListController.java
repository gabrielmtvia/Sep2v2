package main.client.view.client.personaltrainer.list;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.client.core.ViewHandler;

public class ClientPersonalTrainerListController {
    @FXML private TableView tableView;
    @FXML private TableColumn fullName;
    @FXML private TableColumn phoneNumber;
    @FXML private TableColumn startTime;
    @FXML private TableColumn endTime;

    private ClientPersonalTrainerListViewModel clientPersonalTrainerListViewModel;
    private ViewHandler viewHandler;

    public void init(ClientPersonalTrainerListViewModel clientPersonalTrainerListViewModel, ViewHandler viewHandler){
        this.clientPersonalTrainerListViewModel = clientPersonalTrainerListViewModel;
        this.viewHandler = viewHandler;

        fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        startTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endTime.setCellValueFactory(new PropertyValueFactory<>("endTime"));

        tableView.setItems(clientPersonalTrainerListViewModel.getItemsList());
    }

    public void onButtonBook(ActionEvent actionEvent) {
    }

    public void viewMyBookings(ActionEvent actionEvent) {
        viewHandler.openClientPersonalTrainerBooking();
    }

    public void onButtonBack(ActionEvent actionEvent) {
        viewHandler.openClientMain();

    }
}
