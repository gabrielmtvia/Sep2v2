package main.shared;

import java.io.Serializable;
import java.util.Objects;

public class PersonalTrainer implements Serializable
{
  private String name;
  private String phoneNumber;
  private String ssn;

  public PersonalTrainer(String name, String phoneNumber, String ssn)
  {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.ssn = ssn;

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
    return Objects.equals(name, that.name) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(ssn, that.ssn);
  }

}
