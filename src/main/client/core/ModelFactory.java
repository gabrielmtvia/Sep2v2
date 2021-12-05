package main.client.core;

import main.client.model.login.LoginManager;
import main.client.model.login.LoginModel;

public class ModelFactory {

    private ClientFactory clientFactory;
    private LoginModel loginManager;

    public ModelFactory(ClientFactory clientFactory){
        this.clientFactory = clientFactory;
    }

    public LoginModel getLoginManager(){
        if(loginManager==null)
            loginManager = new LoginManager(clientFactory.getLoginClient());
        return loginManager;
    }
}
