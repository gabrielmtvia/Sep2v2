package main.client.view.client.personaltrainer.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.client.model.login.LoginModel;
import main.client.model.personaltrainer.PersonalTrainerModel;
import main.shared.Activity;
import main.shared.PersonalTrainer;

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
    }

    public ArrayList<PersonalTrainer> getPersonalTrainers(){
        return personalTrainerManager.getPersonalTrainers();
    }

    public ObservableList<PersonalTrainer> getItemsList() {
        return items;
    }

    public void bookPersonalTrainer(PersonalTrainer personalTrainer) {
        String response = personalTrainerManager.bookPersonalTrainer(personalTrainer, loginManager.getUserName());
    }
}
