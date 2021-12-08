package main.client.view.staff.clients.add;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import main.client.model.clients.ClientModel;
import main.shared.PersonalTrainer;
import main.shared.TheClient;

public class AddClientViewModel
{
  private ClientModel clientManager;

  private SimpleStringProperty fullnameField;
  private SimpleStringProperty ssnField;
  private SimpleStringProperty usernameField;
  private SimpleStringProperty passwordField;

  public AddClientViewModel(ClientModel clientManager)
  {
    this.clientManager = clientManager;

    fullnameField = new SimpleStringProperty();
    ssnField = new SimpleStringProperty();
    usernameField = new SimpleStringProperty();
    passwordField = new SimpleStringProperty();
  }

  public void saveClient()
  {
    String response = "Connection Error";

    if (getFullnameField() != "" && getSsnField() != "" && getUsernameField() != "" && getPasswordField() != "" && getFullnameField() != null && getSsnField() != null && getUsernameField() != null && getPasswordField() != null){
      TheClient theClient = new TheClient(getFullnameField(), getSsnField(), getUsernameField(), getPasswordField());
      alert(clientManager.saveClient(theClient));
      fullnameField.setValue("");
      ssnField.setValue("");
      usernameField.setValue("");
      passwordField.setValue("");
    }
    else if (getFullnameField() == "" || getFullnameField()==null)
    {
      alert("Please enter a valid name");
    }
    else if (getSsnField() == "" || getSsnField()==null)
    {
      alert("Please enter a valid SSN");
    }
    else if (getUsernameField() == "" || getUsernameField()==null)
    {
      alert("Please enter a valid username");
    }
    else if (getPasswordField() == "" || getPasswordField()==null)
    {
      alert("Please enter a valid password");
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

  public String getFullnameField()
  {
    return fullnameField.get();
  }

  public SimpleStringProperty fullnameFieldProperty()
  {
    return fullnameField;
  }

  public String getSsnField()
  {
    return ssnField.get();
  }

  public SimpleStringProperty ssnFieldProperty()
  {
    return ssnField;
  }

  public String getUsernameField()
  {
    return usernameField.get();
  }

  public SimpleStringProperty usernameFieldProperty()
  {
    return usernameField;
  }

  public String getPasswordField()
  {
    return passwordField.get();
  }

  public SimpleStringProperty passwordFieldProperty()
  {
    return passwordField;
  }
}
