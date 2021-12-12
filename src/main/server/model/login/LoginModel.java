package main.server.model.login;

import main.shared.Password;
import main.shared.UserName;

public interface LoginModel
{
    String validateLoginClient(UserName userName, Password password);
    String validateLoginOwner(UserName userName, Password password);
    String validateLoginStaff(UserName userName, Password password);
}
