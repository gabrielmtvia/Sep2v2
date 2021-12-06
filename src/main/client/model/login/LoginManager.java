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
    public String LoginClient(UserName userName, Password password) {
        return loginClient.LoginClient(userName, password);
    }

    @Override
    public String LoginOwner(UserName userName, Password password) {
        return loginClient.LoginOwner(userName, password);
    }

    @Override
    public String LoginStaff(UserName userName, Password password) {
        return loginClient.LoginStaff(userName, password);
    }
}
