package main.client.view.client.personaltrainer.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.client.model.personaltrainer.PersonalTrainerModel;
import main.shared.Activity;

public class ClientPersonalTrainerListViewModel {

    private ObservableList<Activity> items;
    private PersonalTrainerModel personalTrainerManager;

    public ClientPersonalTrainerListViewModel(PersonalTrainerModel personalTrainerManager){
        items = FXCollections.observableArrayList();
        this.personalTrainerManager = personalTrainerManager;
    }

    public ObservableList<Activity> getItemsList() {
        return items;
    }

}
