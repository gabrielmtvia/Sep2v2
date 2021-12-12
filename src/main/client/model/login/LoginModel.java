package main.client.model.login;

import main.shared.Password;
import main.shared.UserName;

import java.beans.PropertyChangeListener;

public interface LoginModel {
    String loginClient(UserName userName, Password password);
    String loginOwner(UserName userName, Password password);
    String loginStaff(UserName userName, Password password);
    boolean authenticate();
    UserName getUserName();
    void addListener(String eventName, PropertyChangeListener listener);
}
