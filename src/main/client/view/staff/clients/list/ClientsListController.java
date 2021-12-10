package main.client.view.staff.clients.list;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.client.core.ViewHandler;
import main.shared.TheClient;

public class ClientsListController
{
  @FXML private TableView<TheClient> tableView;

  @FXML private TableColumn ssn;
  @FXML private TableColumn name;
  @FXML private TableColumn username;
  @FXML private TableColumn password;

  @FXML Button back;
  @FXML Button save;

  private ClientsListViewModel clientsListViewModel;
  private ViewHandler viewHandler;

  public void init(ClientsListViewModel clientsListViewModel, ViewHandler viewHandler)
  {
    this.clientsListViewModel = clientsListViewModel;
    this.viewHandler = viewHandler;

    ssn.setCellValueFactory(new PropertyValueFactory<>("ssn"));
    name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
    username.setCellValueFactory(new PropertyValueFactory<>("username"));
    password.setCellValueFactory(new PropertyValueFactory<>("password"));

    tableView.setItems(clientsListViewModel.getList());
  }

  public void onDeleteButton(ActionEvent actionEvent)
  {
    ObservableList<Integer> observableList = tableView.getSelectionModel().getSelectedIndices();
    Object[] array = observableList.toArray();
    int position = (int) array[0];

    ObservableList<TheClient> clients = clientsListViewModel.getList();
    TheClient theClient = clients.get(position);

    clientsListViewModel.removeClient(theClient);
  }

  public void onBackButton(ActionEvent actionEvent)
  {
    viewHandler.openClientsMain();
  }

}
