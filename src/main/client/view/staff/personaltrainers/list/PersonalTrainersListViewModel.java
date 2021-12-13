package main.client.view.staff.personaltrainers.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import main.client.model.personaltrainer.PersonalTrainerModel;
import main.shared.PersonalTrainer;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class PersonalTrainersListViewModel
{
  private PersonalTrainerModel personalTrainerManager;
  private ObservableList<PersonalTrainer> list;

  public PersonalTrainersListViewModel(PersonalTrainerModel personalTrainerManager)
  {
    this.personalTrainerManager = personalTrainerManager;
    list  = FXCollections.observableArrayList();
    populateList();

    personalTrainerManager.addListener("Personal Trainer Added", evt -> updateTable(evt));
    personalTrainerManager.addListener("Personal Trainer Removed", evt -> updateTable(evt));
    personalTrainerManager.addListener("Personal Trainer Booked", evt -> updateTable(evt));
    personalTrainerManager.addListener("Personal Trainer Cancelled", evt -> updateTable(evt));
    personalTrainerManager.addListener("Personal Trainer Already Booked", evt -> updateTable(evt));
    personalTrainerManager.addListener("Personal Trainer Already Cancelled", evt -> updateTable(evt));
  }

  private void updateTable(PropertyChangeEvent evt) {
    new Thread(() -> {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      list.clear();
      populateList();
    }).start();
  }

  public void populateList()
  {
    list.addAll(getPersonalTrainers());
  }

  public ArrayList<PersonalTrainer> getPersonalTrainers()
  {
    ArrayList<PersonalTrainer> test = personalTrainerManager.getPersonalTrainers(true);
    if(test==null){
      test = new ArrayList<>();
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("ERROR");
      alert.setContentText("Connection Error. Please restart the program");
      alert.showAndWait();
      return test;
    }else{
      return test;
    }
  }

  public void removePersonalTrainer(PersonalTrainer personalTrainer)
  {
    String response = personalTrainerManager.removePersonalTrainer(personalTrainer);

    if(response.contains("violates")){
      list.add(personalTrainer);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Remove operation");
      alert.setContentText("Cannot remove this personal trainer because it is already \nbooked. Please contact the client\n to inform about the cancellation");
      alert.showAndWait();
    }
    else if(response.contains("resultado")){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Remove operation");
      alert.setContentText("Personal trainer removed successfully");
      alert.showAndWait();
    }else{
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Remove operation");
      alert.setContentText(response);
      alert.showAndWait();
    }
  }

  public ObservableList<PersonalTrainer> getList()
  {
    return list;
  }
}
