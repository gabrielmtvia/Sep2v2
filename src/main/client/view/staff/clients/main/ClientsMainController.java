package main.client.view.staff.clients.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.client.core.ViewHandler;

public class ClientsMainController
{
  @FXML private Button back;
  @FXML private Button addClient;
  @FXML private Button clientsList;

  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
  }

  public void onAddClientButton(ActionEvent actionEvent)
  {
    viewHandler.openAddClient();
  }

  public void onClientsListButton(ActionEvent actionEvent)
  {

  }

  public void onBackButton(ActionEvent actionEvent)
  {
    viewHandler.openStaffMain();
  }
}
