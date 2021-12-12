package main.client.view.staff.clients.add;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.client.core.ViewHandler;

public class AddClientController
{
  @FXML private TextField fullnameField;
  @FXML private TextField ssnField;
  @FXML private TextField usernameField;
  @FXML private TextField passwordField;

  private ViewHandler viewHandler;
  private AddClientViewModel addClientViewModel;

  public void init(AddClientViewModel addClientViewModel, ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    this.addClientViewModel = addClientViewModel;
    fullnameField.textProperty().bindBidirectional(addClientViewModel.fullnameFieldProperty());
    ssnField.textProperty().bindBidirectional(addClientViewModel.ssnFieldProperty());
    usernameField.textProperty().bindBidirectional(addClientViewModel.usernameFieldProperty());
    passwordField.textProperty().bindBidirectional(addClientViewModel.passwordFieldProperty());
  }

  public void onSaveButton()
  {
    addClientViewModel.saveClient();
  }

  public void onBackButton()
  {
    viewHandler.openClientsMain();
  }
}
