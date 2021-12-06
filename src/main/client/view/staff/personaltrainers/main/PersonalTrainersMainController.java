package main.client.view.staff.personaltrainers.main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.client.core.ViewHandler;

public class PersonalTrainersMainController
{

  @FXML private Button addPersonalTrainer;
  @FXML private Button personalTrainersList;
  @FXML private Button back;

  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
  }

  public void onAddPersonalTrainerButtonClick(ActionEvent actionEvent)
  {
    viewHandler.openAddPersonalTrainer();
  }

  public void onPersonalTrainersListButtonClick(ActionEvent actionEvent)
  {
    viewHandler.openPersonalTrainersList();
  }

  public void onBackButtonClick(ActionEvent actionEvent)
  {
    viewHandler.openStaffMain();
  }


}
