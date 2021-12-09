package main.client.view.client.personaltrainer.bookings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.client.model.login.LoginModel;
import main.client.model.personaltrainer.PersonalTrainerModel;
import main.shared.PersonalTrainer;

import java.beans.PropertyChangeEvent;


public class ClientPersonalTrainerBookingViewModel {

    private ObservableList<PersonalTrainer> items;
    private PersonalTrainerModel personalTrainerManager;
    private LoginModel loginManager;

    public ClientPersonalTrainerBookingViewModel(PersonalTrainerModel personalTrainerManager, LoginModel loginManager){
        this.loginManager = loginManager;
        items = FXCollections.observableArrayList();
        this.personalTrainerManager = personalTrainerManager;
        populateList();

        personalTrainerManager.addListener("Personal Trainer Booked", evt -> personalTrainerBooked(evt));
        personalTrainerManager.addListener("Personal Trainer Cancelled", evt -> personalTrainerCancelled(evt));
    }

    private void personalTrainerCancelled(PropertyChangeEvent evt) {
        PersonalTrainer personalTrainerCancelled = (PersonalTrainer) evt.getNewValue();
        items.remove(personalTrainerCancelled);
    }

    private void personalTrainerBooked(PropertyChangeEvent evt) {
        PersonalTrainer personalTrainerBooked = (PersonalTrainer) evt.getNewValue();
        items.add(personalTrainerBooked);
    }

    public void populateList(){
        items.addAll(personalTrainerManager.viewMyBookings(loginManager.getUserName()));
    }

    public ObservableList<PersonalTrainer> getItemsList() {
        return items;
    }

    public void cancelBooking() {
    }
}
