package main.client.view.client.personaltrainer.bookings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import main.client.model.login.LoginModel;
import main.client.model.personaltrainer.PersonalTrainerModel;
import main.shared.PersonalTrainer;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class ClientPersonalTrainerBookingViewModel
{
    private ObservableList<PersonalTrainer> items;
    private PersonalTrainerModel personalTrainerManager;
    private LoginModel loginManager;

    public ClientPersonalTrainerBookingViewModel(PersonalTrainerModel personalTrainerManager, LoginModel loginManager)
    {
        this.loginManager = loginManager;
        items = FXCollections.observableArrayList();
        this.personalTrainerManager = personalTrainerManager;
        populateList();

        personalTrainerManager.addListener("Personal Trainer Booked", evt -> updateTable(evt));
        personalTrainerManager.addListener("Personal Trainer Cancelled", evt -> updateTable(evt));
        loginManager.addListener("New Client", evt -> updateTable(evt));
    }

    private void updateTable(PropertyChangeEvent evt)
    {
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            items.clear();
            populateList();
        }).start();
    }

    public void populateList()
    {
        items.addAll(getMyBookings());
    }

    public ArrayList<PersonalTrainer> getMyBookings()
    {
        return personalTrainerManager.viewMyBookings(loginManager.getUserName());
    }

    public ObservableList<PersonalTrainer> getItemsList()
    {
        return items;
    }

    public void cancelBooking(PersonalTrainer personalTrainer)
    {
        PersonalTrainer personalTrainerCancelled = personalTrainer;
        personalTrainerCancelled.setUsername(loginManager.getUserName().getUserName());
        String result = personalTrainerManager.cancelBooking(personalTrainerCancelled, loginManager.getUserName());
        System.out.println("From the viewmodel");
        System.out.println(personalTrainerCancelled + " "+personalTrainerCancelled.getUsername());

        if(result.contains("result")){
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
