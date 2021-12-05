package main.shared;

import java.io.Serializable;

public class Password implements Serializable {
    private String password;

    public Password(String password){
        if(password == null) throw new IllegalArgumentException("Password can not be null");
        if(password.length()<3 || password.length()>10) throw new IllegalArgumentException("Password has to be between 3 and 10 characters");
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}
