package main.client.view.client.bmi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.client.core.ViewHandler;
import main.shared.BMIData;

public class CalculateBmiController
{
  @FXML private TextField inputHeight;

  @FXML private TextField inputWeight;

  @FXML private Label result;

  private CalculateBmiViewModel calculateBmiViewModel;
  private ViewHandler viewHandler;

  public void init(CalculateBmiViewModel calculateBmiViewModel, ViewHandler viewHandler)
  {
    this.calculateBmiViewModel = calculateBmiViewModel;
    this.viewHandler = viewHandler;

    inputHeight.textProperty().bindBidirectional(calculateBmiViewModel.heightProperty());
    inputWeight.textProperty().bindBidirectional(calculateBmiViewModel.weightProperty());
    result.textProperty().bindBidirectional(calculateBmiViewModel.resultProperty());
  }

  public void onButtonBack(ActionEvent actionEvent)
  {
    viewHandler.openClientMain();
  }

  public void onCalculateBMI(ActionEvent actionEvent)
  {
    calculateBmiViewModel.calculateBMI();
  }

  public void onSave(ActionEvent actionEvent)
  {
    calculateBmiViewModel.save();
  }
  public void onLoad(ActionEvent actionEvent)
  {
    calculateBmiViewModel.load();
  }

  public void onDelete(ActionEvent actionEvent) {
    calculateBmiViewModel.delete();
  }
}
