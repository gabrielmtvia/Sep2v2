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

  @FXML private Button calculateBMI;

  @FXML private TextField inputHeight;

  @FXML private TextField inputWeight;

  @FXML private Label result;

  private CalculateBmiViewModel calculateBmiViewModel;
  private ViewHandler viewHandler;

  public void init(CalculateBmiViewModel calculateBmiViewModel, ViewHandler viewHandler)
  {
    this.calculateBmiViewModel = calculateBmiViewModel;
    this.viewHandler = viewHandler;
  }

  public void onButtonBack(ActionEvent actionEvent)
  {
    viewHandler.openClientMain();
  }

  public void onCalculateBMI(ActionEvent actionEvent)
  {
    int height = Integer.valueOf(inputHeight.getText());
    System.out.println(height);
    int weight = Integer.valueOf(inputWeight.getText());
    System.out.println(weight);

    double dividend = weight;
    double divisor = height * height;
    double BMI = dividend / divisor;
    System.out.println(dividend);
    System.out.println(divisor);
    System.out.println(BMI * 10000);

    result.setText(String.valueOf(BMI * 10000));


  Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("BMI Result");
      alert.setContentText("Less than 15 = Very severely underweight \n"
          + "bmi >= 15 but bmi < 16 = Severely underweight\n"
          + "bmi >= 16 but bmi < 18.5 =  Underweight\n"
          + "bmi >= 18.5 but bmi < 25 = Normal (healthy weight)\n"
          + "bmi >= 25 but bmi < 30 = Overweight\n"
          + "bmi >= 30 but bmi < 35 = Moderately obese\n"
          + "bmi >= 35 but bmi < 40 = Severely obese\n"
          + "bmi > 40 = Very severely obese");
      alert.showAndWait();
}
  public void onSave(ActionEvent actionEvent)
  {
    BMIData bmiData = new BMIData(inputWeight.getText(), inputHeight.getText());
    calculateBmiViewModel.Save(bmiData);
  }
  public void onLoad(ActionEvent actionEvent)
  {

  }
}
