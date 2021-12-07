package main.shared;

import java.io.Serializable;

public class UserName implements Serializable {

    String userName;

    public UserName(String userName){
        if(userName == null) throw new IllegalArgumentException("Username can not be null");
        if(userName.length()<3 || userName.length()>50) throw new IllegalArgumentException("Username has to be between 3 and 10 characters");
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }
}
