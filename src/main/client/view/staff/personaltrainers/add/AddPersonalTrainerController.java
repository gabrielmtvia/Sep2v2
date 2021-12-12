package main.client.view.staff.personaltrainers.add;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import main.client.core.ViewHandler;

public class AddPersonalTrainerController
{
  @FXML private DatePicker datePicker;
  @FXML private TextField time;
  @FXML private TextField nameField;
  @FXML private TextField phoneNumberField;
  @FXML private TextField ssnField;

  private ViewHandler viewHandler;
  AddPersonalTrainerViewModel addPersonalTrainerViewModel;

  public void init(AddPersonalTrainerViewModel addPersonalTrainerViewModel, ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    this.addPersonalTrainerViewModel = addPersonalTrainerViewModel;
    nameField.textProperty().bindBidirectional(addPersonalTrainerViewModel.nameFieldProperty());
    phoneNumberField.textProperty().bindBidirectional(addPersonalTrainerViewModel.phoneNumberFieldProperty());
    ssnField.textProperty().bindBidirectional(addPersonalTrainerViewModel.ssnFieldProperty());
    time.textProperty().bindBidirectional(addPersonalTrainerViewModel.timeProperty());
    //datePicker.getEditor().textProperty().bind(addPersonalTrainerViewModel.dateProperty());
    addPersonalTrainerViewModel.dateProperty().bind(datePicker.getEditor().textProperty());
  }

  public void onSaveButtonClick()
  {
    addPersonalTrainerViewModel.savePersonalTrainer();
  }

  public void onBackButtonClick()
  {
    viewHandler.openPersonalTrainers();
  }
}
