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
    personalTrainerManager.addListener("Personal Trainer Booked", evt -> personalTrainerBooked(evt));
    personalTrainerManager.addListener("Personal Trainer Cancelled", evt -> personalTrainerCancelled(evt));
    personalTrainerManager.addListener("Personal Trainer Already Booked", evt -> personalTrainerAlreadyBooked(evt));
    personalTrainerManager.addListener("Personal Trainer Already Cancelled", evt -> personalTrainerAlreadyCancelled(evt));
  }

  private void personalTrainerAlreadyCancelled(PropertyChangeEvent evt) {
    PersonalTrainer personalTrainerAlreadyCancelled = (PersonalTrainer) evt.getNewValue();
    list.remove(personalTrainerAlreadyCancelled);
    list.add(personalTrainerAlreadyCancelled);
  }

  private void personalTrainerAlreadyBooked(PropertyChangeEvent evt) {
    PersonalTrainer personalTrainerAlreadyBooked = (PersonalTrainer) evt.getNewValue();
    System.out.println(personalTrainerAlreadyBooked);
    System.out.println(list.contains(personalTrainerAlreadyBooked));
    list.remove(personalTrainerAlreadyBooked);
    list.add(personalTrainerAlreadyBooked);
  }

  private void personalTrainerCancelled(PropertyChangeEvent evt) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("listener working");
    alert.setContentText("listener working");
    alert.showAndWait();
  }


  private void personalTrainerBooked(PropertyChangeEvent evt) {
    PersonalTrainer personalTrainerBooked = (PersonalTrainer) evt.getNewValue();
    System.out.println(personalTrainerBooked);
    System.out.println(list.contains(personalTrainerBooked));
    list.remove(personalTrainerBooked);
    list.add(personalTrainerBooked);
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
      alert.setContentText("Cannot remove this time because it is already \nbooked. Please contact the client\n to inform about the cancellation");
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

  public ObservableList<PersonalTrainer> getList(){
    return list;
}

}
