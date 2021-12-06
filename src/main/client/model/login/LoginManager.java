package main.client.model.login;

import main.client.networking.login.LoginClientModel;
import main.shared.Password;
import main.shared.UserName;

public class LoginManager implements LoginModel{

    LoginClientModel loginClient;
    UserName currentUser;

    public LoginManager(LoginClientModel loginClient)
    {
        this.loginClient = loginClient;
    }

    @Override
    public String loginClient(UserName userName, Password password) {
        currentUser = userName;
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
}
