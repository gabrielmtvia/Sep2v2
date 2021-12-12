package main.client.view.client.personaltrainer.list;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.client.core.ViewHandler;
import main.shared.PersonalTrainer;

public class ClientPersonalTrainerListController
{
    @FXML private TableColumn date;
    @FXML private TableView tableView;
    @FXML private TableColumn fullName;
    @FXML private TableColumn phoneNumber;
    @FXML private TableColumn startTime;

    private ClientPersonalTrainerListViewModel clientPersonalTrainerListViewModel;
    private ViewHandler viewHandler;

    public void init(ClientPersonalTrainerListViewModel clientPersonalTrainerListViewModel, ViewHandler viewHandler)
    {
        this.clientPersonalTrainerListViewModel = clientPersonalTrainerListViewModel;
        this.viewHandler = viewHandler;

        fullName.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        startTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.setItems(clientPersonalTrainerListViewModel.getItemsList());
    }

    public void onButtonBook()
    {
        ObservableList<Integer> observableList = tableView.getSelectionModel().getSelectedIndices();
        Object[] array = observableList.toArray();
        int position = (int) array[0];

        ObservableList<PersonalTrainer> personalTrainers = clientPersonalTrainerListViewModel.getItemsList();
        PersonalTrainer personalTrainer = personalTrainers.get(position);

        clientPersonalTrainerListViewModel.bookPersonalTrainer(personalTrainer);
    }

    public void viewMyBookings()
    {
        viewHandler.openClientPersonalTrainerBooking();
    }

    public void onButtonBack()
    {
        viewHandler.openClientMain();
    }
}
