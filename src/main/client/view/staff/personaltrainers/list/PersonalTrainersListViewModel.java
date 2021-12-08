package main.client.view.staff.personaltrainers.list;

import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
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

    personalTrainerManager.addListener("Personal Trainer Added", evt -> personalTrainerAdded(evt));
    personalTrainerManager.addListener("Personal Trainer Removed", evt -> personalTrainerRemoved(evt));
  }

  private void personalTrainerRemoved(PropertyChangeEvent evt) {
    PersonalTrainer personalTrainerRemoved = (PersonalTrainer) evt.getNewValue();
    list.remove(personalTrainerRemoved);
  }

  private void personalTrainerAdded(PropertyChangeEvent evt) {
    PersonalTrainer personalTrainerAdded = (PersonalTrainer) evt.getNewValue();
    list.add(personalTrainerAdded);

  }

  public void populateList()
  {
    list.addAll(getPersonalTrainers());
  }

  public ArrayList<PersonalTrainer> getPersonalTrainers()
  {
    ArrayList<PersonalTrainer> test = personalTrainerManager.getPersonalTrainers();
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

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Remove operation");
    alert.setContentText(response);
    alert.showAndWait();
  }

  public ObservableList<PersonalTrainer> getList(){
    return list;
}

}
