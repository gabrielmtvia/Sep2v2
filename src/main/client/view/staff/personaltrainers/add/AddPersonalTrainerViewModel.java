package main.client.view.staff.personaltrainers.add;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import main.client.model.personaltrainer.PersonalTrainerModel;
import main.shared.PersonalTrainer;

import java.beans.PropertyChangeEvent;

public class AddPersonalTrainerViewModel
{
  private PersonalTrainerModel personalTrainerManager;

  private SimpleStringProperty nameField;
  private SimpleStringProperty phoneNumberField;
  private SimpleStringProperty ssnField;

  public AddPersonalTrainerViewModel(PersonalTrainerModel personalTrainerManager)
  {
    this.personalTrainerManager = personalTrainerManager;

    nameField = new SimpleStringProperty();
    phoneNumberField = new SimpleStringProperty();
    ssnField = new SimpleStringProperty();

  }



  public void savePersonalTrainer()
  {
    String response = "Connection Error";

    if (getNameField() != "" && getPhoneNumberField() != "" && getSsnField() != "" && getNameField() != null && getPhoneNumberField() != null && getSsnField() != null){
      PersonalTrainer personalTrainer = new PersonalTrainer(getNameField(), getPhoneNumberField(), getSsnField());
      alert(personalTrainerManager.savePersonalTrainer(personalTrainer));
      nameField.setValue("");
      phoneNumberField.setValue("");
      ssnField.setValue("");
    }
    else if (getNameField() == "" || getNameField()==null)
    {
      alert("Please enter a valid name");
    }
    else if (getPhoneNumberField() == "" || getPhoneNumberField()==null)
    {
      alert("Please enter a valid phone number");
    }
    else if (getSsnField() == "" || getSsnField()==null)
    {
      alert("Please enter a valid SSN");
    }
    else{
      alert(response);
    }
  }

  public void alert(String response)
  {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Information");
    alert.setContentText(response);
    alert.showAndWait();
  }

  public String getNameField() {
    return nameField.get();
  }

  public SimpleStringProperty nameFieldProperty() {
    return nameField;
  }

  public String getPhoneNumberField() {
    return phoneNumberField.get();
  }

  public SimpleStringProperty phoneNumberFieldProperty() {
    return phoneNumberField;
  }

  public String getSsnField() {
    return ssnField.get();
  }

  public SimpleStringProperty ssnFieldProperty() {
    return ssnField;
  }
}
