package main.client.model.login;

import main.client.networking.login.LoginClientModel;
import main.shared.Password;
import main.shared.UserName;

public class LoginManager implements LoginModel{

    LoginClientModel loginClient;

    public LoginManager(LoginClientModel loginClient)
    {
        this.loginClient = loginClient;
    }

    @Override
    public String loginClient(UserName userName, Password password) {
        return loginClient.loginClient(userName, password);
    }

    @Override
    public String loginOwner(UserName userName, Password password) {
        return loginClient.loginOwner(userName, password);
    }

    @Override
    public String loginStaff(UserName userName, Password password) {
        return loginClient.loginStaff(userName, password);
    }

    @Override
    public void authenticate() {
        loginClient.authenticate();
    }
}
