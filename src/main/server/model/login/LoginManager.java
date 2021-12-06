package main.server.model.login;

import main.server.persistence.login.LoginDAOModel;
import main.shared.Password;
import main.shared.UserName;

public class LoginManager implements LoginModel{

    private LoginDAOModel loginDAO;

    public LoginManager(LoginDAOModel loginDAO){
        this.loginDAO = loginDAO;
    }

    @Override
    public String validateLoginClient(UserName userName, Password password) {
        return loginDAO.validateLoginClient(userName,password);
    }
}
