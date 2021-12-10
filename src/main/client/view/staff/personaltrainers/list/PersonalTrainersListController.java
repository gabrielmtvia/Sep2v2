package main.client.view.staff.personaltrainers.list;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.client.core.ViewHandler;
import main.shared.PersonalTrainer;

import java.util.ArrayList;


public class PersonalTrainersListController
{
  @FXML private TableColumn username;
  @FXML private TableColumn date;
  @FXML private TableColumn startTime;
  @FXML private TableColumn name;
  @FXML private TableColumn phoneNumber;
  @FXML private TableColumn ssn;
  @FXML private TableView<PersonalTrainer> personalTrainersTableView;

  @FXML private Button removeButton;
  @FXML private Button backButton;

  private PersonalTrainersListViewModel personalTrainersListViewModel;
  private ViewHandler viewHandler;

  public void init(PersonalTrainersListViewModel personalTrainersListViewModel, ViewHandler viewHandler)
  {
    this.personalTrainersListViewModel = personalTrainersListViewModel;
    this.viewHandler = viewHandler;

    name.setCellValueFactory(new PropertyValueFactory<>("name"));
    phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    ssn.setCellValueFactory(new PropertyValueFactory<>("ssn"));
    date.setCellValueFactory(new PropertyValueFactory<>("date"));
    startTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
    username.setCellValueFactory(new PropertyValueFactory<>("username"));

    personalTrainersTableView.setItems(personalTrainersListViewModel.getList());
  }

  public void onRemoveButtonClick(ActionEvent actionEvent)
  {
    ObservableList<Integer> observableList = personalTrainersTableView.getSelectionModel().getSelectedIndices();
    Object[] array = observableList.toArray();
    int position = (int) array[0];

    ObservableList<PersonalTrainer> personalTrainers = personalTrainersListViewModel.getList();
    PersonalTrainer personalTrainer = personalTrainers.get(position);

    personalTrainersListViewModel.removePersonalTrainer(personalTrainer);
  }

  public void onBackButtonClick(ActionEvent actionEvent)
  {
    viewHandler.openPersonalTrainers();
  }
}
