package main.client.core;

import main.client.model.activities.ActivitiesManager;
import main.client.model.activities.ActivitiesModel;
import main.client.model.login.LoginManager;
import main.client.model.login.LoginModel;
import main.client.model.bmi.BmiManager;
import main.client.model.bmi.BmiModel;

public class ModelFactory {

    private ClientFactory clientFactory;
    private LoginModel loginManager;
    private ActivitiesModel activitiesManager;
    private BmiModel bmiManager;

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

    public BmiModel getBmiManager(){
        if(bmiManager==null)
            bmiManager = new BmiManager(clientFactory.getBmiClient());
        return bmiManager;
    }

}
