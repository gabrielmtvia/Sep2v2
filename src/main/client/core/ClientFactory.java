package main.client.core;

import main.client.networking.activities.ActivitiesClient;
import main.client.networking.activities.ActivitiesClientModel;
import main.client.networking.bmi.BmiClient;
import main.client.networking.bmi.BmiClientModel;
import main.client.networking.login.LoginClient;
import main.client.networking.login.LoginClientModel;
import main.client.networking.rmi.RemoteClient;
import main.client.networking.rmi.RmiClient;

public class ClientFactory {

    private RemoteClient rmiClient;
    private LoginClientModel loginClient;
    private ActivitiesClientModel activitiesClient;
    private BmiClientModel bmiClient;

    public ClientFactory(){
        rmiClient = new RmiClient();
    }

    public LoginClientModel getLoginClient(){
        if(loginClient==null)
            loginClient = new LoginClient(rmiClient);
        return loginClient;
    }

    public ActivitiesClientModel getActivitiesClient(){
        if(activitiesClient==null)
            activitiesClient = new ActivitiesClient(rmiClient);
        return activitiesClient;
    }

    public BmiClientModel getBmiClient(){
        if(bmiClient==null)
            bmiClient = new BmiClient(rmiClient);
        return bmiClient;
    }

}
