package main.shared;

import java.io.Serializable;

public class BMIData implements Serializable
{
  private String weight;
  private String height;
  private String userName;


  public BMIData(String weight, String height) {
    this.weight = weight;
    this.height = height;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}