package main.client.networking.login;

import main.client.networking.rmi.RemoteClient;
import main.shared.Password;
import main.shared.UserName;

import java.rmi.RemoteException;

public class LoginClient implements LoginClientModel{

    private RemoteClient rmiClient;

    public LoginClient(RemoteClient rmiClient){
        this.rmiClient = rmiClient;
    }

    @Override
    public String LoginClient(UserName userName, Password password) {
        try {
            return rmiClient.LoginClient(userName, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return "Connection failed";
    }
}
