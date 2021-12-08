package main.client.view.client.personaltrainer.bookings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.client.model.personaltrainer.PersonalTrainerModel;
import main.shared.Activity;

public class ClientPersonalTrainerBookingViewModel {

    private ObservableList<Activity> items;
    private PersonalTrainerModel personalTrainerManager;

    public ClientPersonalTrainerBookingViewModel(PersonalTrainerModel personalTrainerManager){
        items = FXCollections.observableArrayList();
        this.personalTrainerManager = personalTrainerManager;
    }

    public ObservableList<Activity> getItemsList() {
        return items;
    }

    public void cancelBooking() {
    }
}
