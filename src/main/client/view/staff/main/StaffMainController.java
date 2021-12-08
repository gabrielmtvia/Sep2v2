package main.client.view.staff.main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.client.core.ViewHandler;

public class StaffMainController
{
  @FXML private Button activities;
  @FXML private Button clients;
  @FXML private Button personalTrainers;
  @FXML private Button back;

  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
  }


  public void onActivitiesButtonClick(ActionEvent actionEvent)
  {
     viewHandler.openManageActivities();
  }

  public void onClientsButtonClick(ActionEvent actionEvent)
  {
    viewHandler.openClientsMain();
  }

  public void onPersonalTrainersButtonClick(ActionEvent actionEvent)
  {
    viewHandler.openPersonalTrainers();
  }

  public void onBackButtonClick(ActionEvent actionEvent)
  {
    viewHandler.openStaffLogin();
  }
}
