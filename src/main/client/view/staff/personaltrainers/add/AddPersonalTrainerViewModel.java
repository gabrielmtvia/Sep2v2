package main.client.view.staff.personaltrainers.add;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import main.client.model.personaltrainer.PersonalTrainerModel;
import main.shared.PersonalTrainer;

import java.util.regex.PatternSyntaxException;

public class AddPersonalTrainerViewModel
{
  private PersonalTrainerModel personalTrainerManager;

  private SimpleStringProperty nameField;
  private SimpleStringProperty phoneNumberField;
  private SimpleStringProperty ssnField;
  private SimpleStringProperty date;
  private SimpleStringProperty time;

  public AddPersonalTrainerViewModel(PersonalTrainerModel personalTrainerManager)
  {
    this.personalTrainerManager = personalTrainerManager;

    nameField = new SimpleStringProperty();
    phoneNumberField = new SimpleStringProperty();
    ssnField = new SimpleStringProperty();
    date = new SimpleStringProperty();
    time = new SimpleStringProperty();
  }

  public void savePersonalTrainer()
  {
    String response = "Connection Error";

    if (getNameField() != "" && getPhoneNumberField() != "" && getSsnField() != "" && getTime() != "" && getTime() != null
            && getNameField() != null && getPhoneNumberField() != null && getSsnField() != null && getDate() != null){

      boolean error = false;

      String[] dateSplit = date.getValue().split("/");
      String day = dateSplit[0];
      String month = dateSplit[1];
      String year = dateSplit[2];
      String dbFormat = year+"-"+month+"-"+day;

      try{
        Integer.valueOf(getPhoneNumberField());
      } catch (NumberFormatException e) {
        alert("Please enter a valid phone number");
        error = true;
      }

      try{
        Integer.valueOf(getSsnField());
      } catch (NumberFormatException e) {
        alert("Please enter a valid SSN");
        error = true;
      }


      String[] timeSplit;

      try{
        timeSplit = getTime().split(":");
        if(timeSplit.length != 2){
          error = true;
          alert("Incorrect time format\n Please enter a time in the format HH:MM");
        }else{
          Integer.parseInt(timeSplit[0]);
          Integer.parseInt(timeSplit[1]);
        }

      }catch (PatternSyntaxException e){
        alert("Incorrect time format\n Please enter a time in the format HH:MM");
        error = true;
      }

      if(!error){
        PersonalTrainer personalTrainer = new PersonalTrainer(getNameField(), getPhoneNumberField(), getSsnField(), getTime(), dbFormat);
        alert(personalTrainerManager.savePersonalTrainer(personalTrainer));
        nameField.setValue("");
        phoneNumberField.setValue("");
        ssnField.setValue("");
        time.setValue("");
      }
    }
    else if (getNameField() == "" || getNameField()==null)
    {
      alert("Please enter a name");
    }
    else if (getPhoneNumberField() == "" || getPhoneNumberField()==null)
    {
      alert("Please enter a phone number");
    }
    else if (getSsnField() == "" || getSsnField()==null)
    {
      alert("Please enter a SSN");
    }
    else if(getTime() != "" || getTime() != null){
      alert("Please enter a time in the format HH:MM");
    }
    else{
      alert(response);
    }
  }

  public void alert(String response)
  {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information");
    alert.setContentText(response);
    alert.showAndWait();
  }

  public String getNameField()
  {
    return nameField.get();
  }

  public SimpleStringProperty nameFieldProperty()
  {
    return nameField;
  }

  public String getPhoneNumberField()
  {
    return phoneNumberField.get();
  }

  public SimpleStringProperty phoneNumberFieldProperty()
  {
    return phoneNumberField;
  }

  public String getSsnField()
  {
    return ssnField.get();
  }

  public SimpleStringProperty ssnFieldProperty()
  {
    return ssnField;
  }

  public String getDate()
  {
    return date.get();
  }

  public SimpleStringProperty dateProperty()
  {
    return date;
  }

  public String getTime()
  {
    return time.get();
  }

  public SimpleStringProperty timeProperty()
  {
    return time;
  }
}
