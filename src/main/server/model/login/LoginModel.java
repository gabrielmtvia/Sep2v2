package main.server.model.login;

import main.shared.Password;
import main.shared.UserName;

public interface LoginModel {
    public String validateLoginClient(UserName userName, Password password);
}
