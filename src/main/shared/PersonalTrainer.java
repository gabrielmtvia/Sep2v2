package main.shared;

import java.io.Serializable;
import java.util.Objects;

public class PersonalTrainer implements Serializable
{
  private String name;
  private String phoneNumber;
  private String ssn;
  private String startTime;
  private String date;
  private String username;

  public PersonalTrainer(String name, String phoneNumber, String ssn)
  {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.ssn = ssn;

  }

  public PersonalTrainer(String name, String phoneNumber, String ssn, String startTime, String date)
  {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.ssn = ssn;
    this.startTime = startTime;
    this.date = date;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getUsername(){
    return username;
  }

  public String getStartTime()
  {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public void setSsn(String ssn)
  {
    this.ssn = ssn;
  }

  public String getName()
  {
    return name;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public String getSsn()
  {
    return ssn;
  }

  public String toString()
  {
    return "Name: " + this.name + ", Phone Number: " + this.phoneNumber + ", SSN: " + this.ssn;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PersonalTrainer that = (PersonalTrainer) o;
    return Objects.equals(name, that.name) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(ssn, that.ssn) && Objects.equals(startTime, that.startTime) && Objects.equals(date, that.date);
  }

}
