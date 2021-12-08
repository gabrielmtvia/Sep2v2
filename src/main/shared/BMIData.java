package main.shared;

import java.io.Serializable;

public class BMIData implements Serializable
{
  private double weight;
  private double height;
  private String userName;


  public BMIData(double weight, double height) {
    this.weight = weight;
    this.height = height;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
  public String toString() {
    return "BMIData{" +
            "weight=" + weight +
            ", height=" + height +
            ", userName='" + userName + '\'' +
            '}';
  }
}