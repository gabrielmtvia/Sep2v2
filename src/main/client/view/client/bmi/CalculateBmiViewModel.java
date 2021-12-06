package main.client.view.client.bmi;


import main.client.model.bmi.BmiModel;
import main.client.model.login.LoginModel;
import main.shared.BMIData;
import main.shared.UserName;

public class CalculateBmiViewModel
{
  private BmiModel bmiManager;
  private LoginModel loginManager;
  private UserName userName;

  public CalculateBmiViewModel(BmiModel bmiManager, LoginModel loginManager){
    this.bmiManager = bmiManager;
    this.loginManager = loginManager;
  }

  public void Save(BMIData data){
    BMIData bmiData = data;
    userName = loginManager.getUserName();
    bmiData.setUserName(userName.getUserName());

    System.out.println(userName.getUserName());
    String response = bmiManager.saveBmiData(bmiData);
    System.out.println(response);
  }

}
