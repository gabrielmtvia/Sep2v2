package main.client.view.client.personaltrainer.bookings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import main.client.model.login.LoginModel;
import main.client.model.personaltrainer.PersonalTrainerModel;
import main.shared.PersonalTrainer;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;


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
        System.out.println("trying to cancel appointment, items contains personal trainer?");
        System.out.println(items.contains(personalTrainerCancelled));
        items.remove(personalTrainerCancelled);
    }

    private void personalTrainerBooked(PropertyChangeEvent evt) {
        PersonalTrainer personalTrainerBooked = (PersonalTrainer) evt.getNewValue();
        if(personalTrainerBooked.getUsername().equals(loginManager.getUserName().getUserName()))
        {
            items.add(personalTrainerBooked);
        }
    }

    public void populateList(){
        items.addAll(getMyBookings());
    }

    public ArrayList<PersonalTrainer> getMyBookings(){
        return personalTrainerManager.viewMyBookings(loginManager.getUserName());
    }

    public ObservableList<PersonalTrainer> getItemsList() {
        return items;
    }

    public void cancelBooking(PersonalTrainer personalTrainer) {
        PersonalTrainer personalTrainerCancelled = personalTrainer;
        personalTrainerCancelled.setUsername(loginManager.getUserName().getUserName());
        String result = personalTrainerManager.cancelBooking(personalTrainerCancelled, loginManager.getUserName());
        System.out.println("From the viewmodel");
        System.out.println(personalTrainerCancelled + " "+personalTrainerCancelled.getUsername());

        if(result.contains("resultado")){
            items.remove(personalTrainer);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Successfully cancelled the booking");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText(result);
            alert.showAndWait();
        }
    }
}
