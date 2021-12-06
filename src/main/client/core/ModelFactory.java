package main.client.core;

import main.client.model.activities.ActivitiesManager;
import main.client.model.activities.ActivitiesModel;
import main.client.model.login.LoginManager;
import main.client.model.login.LoginModel;

public class ModelFactory {

    private ClientFactory clientFactory;
    private LoginModel loginManager;
    private ActivitiesModel activitiesManager;

    public ModelFactory(ClientFactory clientFactory){
        this.clientFactory = clientFactory;
    }

    public LoginModel getLoginManager(){
        if(loginManager==null)
            loginManager = new LoginManager(clientFactory.getLoginClient());
        return loginManager;
    }

    public ActivitiesModel getActivitiesManager(){
        if(activitiesManager==null)
            activitiesManager = new ActivitiesManager(clientFactory.getActivitiesClient());
        return activitiesManager;
    }

}
