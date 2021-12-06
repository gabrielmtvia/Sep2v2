package main.server.persistence.login;

import main.shared.Password;
import main.shared.UserName;

public interface LoginDAOModel {
    String validateLoginClient(UserName userName, Password password);
    String validateLoginOwner(UserName userName, Password password);
    String validateLoginStaff(UserName userName, Password password);
}
