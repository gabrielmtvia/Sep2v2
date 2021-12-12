package main.client.view.client.bmi;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import main.client.model.bmi.BmiModel;
import main.client.model.login.LoginModel;
import main.shared.BMIData;
import main.shared.UserName;

public class CalculateBmiViewModel
{
  private BmiModel bmiManager;
  private LoginModel loginManager;
  private UserName userName;

  private SimpleStringProperty height;
  private SimpleStringProperty weight;
  private SimpleStringProperty result;

  public CalculateBmiViewModel(BmiModel bmiManager, LoginModel loginManager)
  {
    this.bmiManager = bmiManager;
    this.loginManager = loginManager;

    height = new SimpleStringProperty();
    weight = new SimpleStringProperty();
    result = new SimpleStringProperty();
  }

  public void calculateBMI()
  {
    boolean error = false;
    double inputHeight = 0;
    double inputWeight = 0;
    try{
      inputHeight = Double.valueOf(height.getValue());
      inputWeight = Double.valueOf(weight.getValue());
    }catch (Exception e){
      alert("Input error", "Please input a numeric value");
      error = true;
    }

    if(!error)
    {
      double dividend = inputWeight;
      double divisor = inputHeight * inputHeight;
      double bmi = dividend / divisor;

      int roundedBmi = (int) (bmi * 10000);
      result.set(String.valueOf(roundedBmi));

      alert("BMI Result", "Less than 15 = Very severely underweight \n"
              + "bmi >= 15 but bmi < 16 = Severely underweight\n"
              + "bmi >= 16 but bmi < 18 =  Underweight\n"
              + "bmi >= 18 but bmi < 25 = Normal (healthy weight)\n"
              + "bmi >= 25 but bmi < 30 = Overweight\n"
              + "bmi >= 30 but bmi < 35 = Moderately obese\n"
              + "bmi >= 35 but bmi < 40 = Severely obese\n"
              + "bmi > 40 = Very severely obese");
    }
    weight.set("");
    height.set("");
    result.set("");
  }

  public void alert(String title, String text)
  {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setContentText(text);
    alert.showAndWait();
  }

  public void save()
  {
    boolean error = false;
    if(weight.getValue()!=null&&weight.getValue()!=""&&height.getValue()!=null&&height.getValue()!="")
    {
      try{
        Double.valueOf(weight.getValue());
        Double.valueOf(height.getValue());
      } catch (NumberFormatException e) {
        alert("Not a valid number", "Please enter a valid number");
        error = true;
      }

      if(!error){
        BMIData bmiData = new BMIData(Double.parseDouble(weight.getValue()), Double.parseDouble(height.getValue()));
        userName = loginManager.getUserName();
        bmiData.setUserName(userName.getUserName());

        String response = bmiManager.saveBmiData(bmiData);
        alert("Save operation", response);
      }
      weight.set("");
      height.set("");
      result.set("");

    }
    else{
      alert("Empty fields", "Please enter both values");
    }
  }

  public void load()
  {
    BMIData loadedData = bmiManager.loadBmiData(loginManager.getUserName());
    if(loadedData==null){
      alert("Connection error", "Connection error");
    }else {
      height.setValue(String.valueOf(loadedData.getHeight()));
      weight.setValue(String.valueOf(loadedData.getWeight()));
    }
  }

  public void delete()
  {
    String response = bmiManager.deleteBmiData(loginManager.getUserName());
    alert("Delete operation", response);
    weight.set("");
    height.set("");
    result.set("");
  }

  public SimpleStringProperty heightProperty()
  {
    return height;
  }

  public SimpleStringProperty weightProperty()
  {
    return weight;
  }

  public SimpleStringProperty resultProperty()
  {
    return result;
  }
}
