package main.client.core;

import main.client.networking.login.LoginClient;
import main.client.networking.login.LoginClientModel;
import main.client.networking.rmi.RemoteClient;
import main.client.networking.rmi.RmiClient;

public class ClientFactory {

    private RemoteClient rmiClient;
    private LoginClientModel loginClient;

    public ClientFactory(){
        rmiClient = new RmiClient();
    }

    public LoginClientModel getLoginClient(){
        if(loginClient==null)
            loginClient = new LoginClient(rmiClient);
        return loginClient;
    }
}
