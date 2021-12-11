package main.shared;

import java.io.Serializable;
import java.util.Objects;

public class TheClient implements Serializable
{
  private String fullName;
  private String ssn;
  private String username;
  private String password;

  public TheClient(String fullName, String ssn, String username, String password)
  {
    this.fullName = fullName;
    this.ssn = ssn;
    this.username = username;
    this.password = password;
  }

  public void setFullName(String fullName)
  {
    this.fullName = fullName;
  }

  public void setSsn(String ssn)
  {
    this.ssn = ssn;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getFullName()
  {
    return fullName;
  }

  public String getSsn()
  {
    return ssn;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  public String toString()
  {
    return "SSN: " + this.ssn + ", Name: " + this.fullName + ", Username: " + this.username + ", Password: " + this.password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TheClient theClient = (TheClient) o;
    return Objects.equals(fullName, theClient.fullName) && Objects.equals(ssn, theClient.ssn) && Objects.equals(username, theClient.username) && Objects.equals(password, theClient.password);
  }

}
