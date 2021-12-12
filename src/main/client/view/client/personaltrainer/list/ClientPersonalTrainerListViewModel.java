package main.client.view.client.personaltrainer.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
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

        personalTrainerManager.addListener("Personal Trainer Booked", evt -> updateTable(evt));
        personalTrainerManager.addListener("Personal Trainer Cancelled", evt -> updateTable(evt));

        personalTrainerManager.addListener("Personal Trainer Added", evt -> updateTable(evt));
        personalTrainerManager.addListener("Personal Trainer Removed", evt -> updateTable(evt));
        personalTrainerManager.addListener("Personal Trainer Already Booked", evt -> updateTable(evt));
        personalTrainerManager.addListener("Personal Trainer Already Cancelled", evt -> updateTable(evt));
        loginManager.addListener("New Client", evt -> updateTable(evt));
    }

    private void updateTable(PropertyChangeEvent evt) {
        new Thread(() -> {
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            items.clear();
            items.addAll(getPersonalTrainers());
        }).start();
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

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText(response);
        alert.showAndWait();
    }
}
