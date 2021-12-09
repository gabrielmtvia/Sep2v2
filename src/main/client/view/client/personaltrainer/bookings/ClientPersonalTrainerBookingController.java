package main.client.view.client.personaltrainer.bookings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.client.core.ViewHandler;

public class ClientPersonalTrainerBookingController {

    @FXML private TableColumn date;
    @FXML private TableView tableView;
    @FXML private TableColumn fullName;
    @FXML private TableColumn phoneNumber;
    @FXML private TableColumn startTime;

    private ClientPersonalTrainerBookingViewModel viewModel;
    private ViewHandler viewHandler;

    public void init(ClientPersonalTrainerBookingViewModel viewModel, ViewHandler viewHandler){
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;

        fullName.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        startTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.setItems(viewModel.getItemsList());
    }

    public void onButtonBack(ActionEvent actionEvent) {
        viewHandler.openClientPersonalTrainer();
    }

    public void onCancelBooking(ActionEvent actionEvent) {
        viewModel.cancelBooking();
    }
}
