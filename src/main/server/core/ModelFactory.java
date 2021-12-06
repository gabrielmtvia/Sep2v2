package main.server.core;

import main.server.model.login.LoginManager;
import main.server.model.login.LoginModel;

public class ModelFactory {

    private DAOFactory daoFactory;
    private LoginModel loginManager;

    public ModelFactory(DAOFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    public LoginModel getLoginManager(){
        if(loginManager == null)
            loginManager = new LoginManager(daoFactory.getLoginDAO());
        return loginManager;
    }
}
