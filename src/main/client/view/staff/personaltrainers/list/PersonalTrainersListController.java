package main.client.view.staff.personaltrainers.list;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import main.client.core.ViewHandler;
import main.shared.PersonalTrainer;

import java.util.ArrayList;


public class PersonalTrainersListController
{
  @FXML private ListView personalTrainersListView;
  @FXML private Button removeButton;
  @FXML private Button backButton;

  private PersonalTrainersListViewModel personalTrainersListViewModel;
  private ViewHandler viewHandler;

  public void init(PersonalTrainersListViewModel personalTrainersListViewModel, ViewHandler viewHandler)
  {
    this.personalTrainersListViewModel = personalTrainersListViewModel;
    this.viewHandler = viewHandler;


    personalTrainersListView.itemsProperty().bindBidirectional(personalTrainersListViewModel.getPersonalTrainersList());
    personalTrainersListViewModel.populateList();
  }

  public void onRemoveButtonClick(ActionEvent actionEvent)
  {
    ObservableList<String> observableList = personalTrainersListView.getSelectionModel().getSelectedIndices();
    Object[] array = observableList.toArray();
    int position = (int) array[0];

    ArrayList<PersonalTrainer> personalTrainers = personalTrainersListViewModel.getPersonalTrainers();
    PersonalTrainer personalTrainer = personalTrainers.get(position);

    personalTrainersListViewModel.removePersonalTrainer(personalTrainer);


  }

  public void onBackButtonClick(ActionEvent actionEvent)
  {
    viewHandler.openPersonalTrainers();
  }
}
