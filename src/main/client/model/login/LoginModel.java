package main.client.model.login;

import main.shared.Password;
import main.shared.UserName;

public interface LoginModel {
    String LoginClient(UserName userName, Password password);
    String LoginOwner(UserName userName, Password password);
    String LoginStaff(UserName userName, Password password);
}
