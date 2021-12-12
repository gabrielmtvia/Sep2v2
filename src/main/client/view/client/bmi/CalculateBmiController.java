package main.client.view.client.bmi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.client.core.ViewHandler;

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

  public void onButtonBack()
  {
    viewHandler.openClientMain();
  }

  public void onCalculateBMI()
  {
    calculateBmiViewModel.calculateBMI();
  }

  public void onSave()
  {
    calculateBmiViewModel.save();
  }
  public void onLoad()
  {
    calculateBmiViewModel.load();
  }

  public void onDelete()
  {
    calculateBmiViewModel.delete();
  }
}
