package main.client.view.client.personaltrainer.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.client.model.login.LoginModel;
import main.client.model.personaltrainer.PersonalTrainerModel;
import main.shared.PersonalTrainer;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class ClientPersonalTrainerListViewModel {

    private ObservableList<PersonalTrainer> items;
    private PersonalTrainerModel personalTrainerManager;
    private LoginModel loginManager;

    public ClientPersonalTrainerListViewModel(PersonalTrainerModel personalTrainerManager, LoginModel loginManager){
        this.loginManager = loginManager;
        items = FXCollections.observableArrayList();
        this.personalTrainerManager = personalTrainerManager;
        items.addAll(getPersonalTrainers());

        personalTrainerManager.addListener("Personal Trainer Booked", evt -> personalTrainerBooked(evt));
        personalTrainerManager.addListener("Personal Trainer Cancelled", evt -> personalTrainerCancelled(evt));

        personalTrainerManager.addListener("Personal Trainer Added", evt -> personalTrainerAdded(evt));
        personalTrainerManager.addListener("Personal Trainer Removed", evt -> personalTrainerRemoved(evt));
        personalTrainerManager.addListener("Personal Trainer Already Booked", evt -> personalTrainerRemoved(evt));
    }

    private void personalTrainerRemoved(PropertyChangeEvent evt) {
        PersonalTrainer personalTrainerRemoved = (PersonalTrainer) evt.getNewValue();
        items.remove(personalTrainerRemoved);
    }

    private void personalTrainerAdded(PropertyChangeEvent evt) {
        PersonalTrainer personalTrainerAdded = (PersonalTrainer) evt.getNewValue();
        items.add(personalTrainerAdded);
    }

    private void personalTrainerCancelled(PropertyChangeEvent evt) {
        PersonalTrainer personalTrainerCancelled = (PersonalTrainer) evt.getNewValue();
        items.add(personalTrainerCancelled);
    }

    private void personalTrainerBooked(PropertyChangeEvent evt) {
        PersonalTrainer personalTrainerBooked = (PersonalTrainer) evt.getNewValue();
        items.remove(personalTrainerBooked);
    }

    public ArrayList<PersonalTrainer> getPersonalTrainers(){
        return personalTrainerManager.getPersonalTrainers(false);
    }

    public ObservableList<PersonalTrainer> getItemsList() {
        return items;
    }

    public void bookPersonalTrainer(PersonalTrainer personalTrainer) {
        PersonalTrainer personalTrainerWithUsername= personalTrainer;
        personalTrainerWithUsername.setUsername(loginManager.getUserName().getUserName());
        String response = personalTrainerManager.bookPersonalTrainer(personalTrainerWithUsername, loginManager.getUserName());
        System.out.println(response);
    }
}
