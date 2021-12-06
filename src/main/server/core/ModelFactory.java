package main.server.core;

import main.server.model.activities.ActivitiesManager;
import main.server.model.activities.ActivitiesModel;
import main.server.model.login.LoginManager;
import main.server.model.login.LoginModel;

public class ModelFactory {

    private DAOFactory daoFactory;
    private LoginModel loginManager;
    private ActivitiesModel activitiesManager;

    public ModelFactory(DAOFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    public LoginModel getLoginManager(){
        if(loginManager == null)
            loginManager = new LoginManager(daoFactory.getLoginDAO());
        return loginManager;
    }

    public ActivitiesModel getActivitiesManager(){
        if(activitiesManager==null)
            activitiesManager = new ActivitiesManager(daoFactory.getActivitiesDAO());
        return activitiesManager;
    }
}
