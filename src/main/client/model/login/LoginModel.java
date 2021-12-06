package main.client.model.login;

import main.shared.Password;
import main.shared.UserName;

public interface LoginModel {
    String loginClient(UserName userName, Password password);
    String loginOwner(UserName userName, Password password);
    String loginStaff(UserName userName, Password password);
    void authenticate();
    UserName getUserName();
}
