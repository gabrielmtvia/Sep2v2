package main.server.persistence.login;

import main.shared.Password;
import main.shared.UserName;

public interface LoginDAOModel {
    public String validateLoginClient(UserName userName, Password password);
}
