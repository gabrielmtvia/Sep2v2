package main.client.view.staff.personaltrainers.add;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.client.core.ViewHandler;

public class AddPersonalTrainerController
{
  @FXML private TextField nameField;
  @FXML private TextField phoneNumberField;
  @FXML private TextField ssnField;

  @FXML private Button save;
  @FXML private Button back;

  private ViewHandler viewHandler;
  AddPersonalTrainerViewModel addPersonalTrainerViewModel;

  public void init(AddPersonalTrainerViewModel addPersonalTrainerViewModel, ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    this.addPersonalTrainerViewModel = addPersonalTrainerViewModel;
    nameField.textProperty().bindBidirectional(addPersonalTrainerViewModel.nameFieldProperty());
    phoneNumberField.textProperty().bindBidirectional(addPersonalTrainerViewModel.phoneNumberFieldProperty());
    ssnField.textProperty().bindBidirectional(addPersonalTrainerViewModel.ssnFieldProperty());
  }


  public void onSaveButtonClick(ActionEvent actionEvent)
  {
      addPersonalTrainerViewModel.savePersonalTrainer();

  }

  public void onBackButtonClick(ActionEvent actionEvent)
  {
    viewHandler.openPersonalTrainers();
  }

}
