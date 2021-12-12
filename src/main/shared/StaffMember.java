package main.shared;

import java.io.Serializable;
import java.util.Objects;

public class StaffMember implements Serializable
{
    private String SSN;
    private String fullName;
    private String userName;
    private String password;

    public StaffMember(String SSN, String fullName, String userName, String password)
    {
        this.SSN = SSN;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
    }

    public String getSSN()
    {
        return SSN;
    }

    public void setSSN(String SSN)
    {
        this.SSN = SSN;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return  "SSN:     " + SSN + "   Full Name:   " + fullName + "   Username:   " + userName + "   Password:   " + password;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffMember that = (StaffMember) o;
        return Objects.equals(SSN, that.SSN) && Objects.equals(fullName, that.fullName) && Objects.equals(userName, that.userName) && Objects.equals(password, that.password);
    }
}
