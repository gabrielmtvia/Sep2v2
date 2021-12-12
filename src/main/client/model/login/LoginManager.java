package main.client.model.login;

import main.client.networking.login.LoginClientModel;
import main.shared.Password;
import main.shared.UserName;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Date;

public class LoginManager implements LoginModel{

    LoginClientModel loginClient;
    UserName currentUser;

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public LoginManager(LoginClientModel loginClient)
    {
        this.loginClient = loginClient;
    }

    @Override
    public String loginClient(UserName userName, Password password) {
        currentUser = userName;
        support.firePropertyChange("New Client", null, "New Client");
        return loginClient.loginClient(userName, password);
    }

    @Override
    public String loginOwner(UserName userName, Password password) {
        currentUser = userName;
        return loginClient.loginOwner(userName, password);
    }

    @Override
    public String loginStaff(UserName userName, Password password) {
        currentUser = userName;
        return loginClient.loginStaff(userName, password);
    }

    @Override
    public boolean authenticate() {
        return loginClient.authenticate();
    }

    @Override
    public UserName getUserName() {
        return currentUser;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)) {
            support.addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(eventName, listener);
        }
    }
}
