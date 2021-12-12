package main.client.networking.login;

import main.client.networking.rmi.RemoteClient;
import main.shared.Password;
import main.shared.UserName;

import java.rmi.RemoteException;

public class LoginClient implements LoginClientModel
{
    private RemoteClient rmiClient;

    public LoginClient(RemoteClient rmiClient)
    {
        this.rmiClient = rmiClient;
    }

    @Override
    public String loginClient(UserName userName, Password password)
    {
        try {
            return rmiClient.loginClient(userName, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return "Connection failed";
    }

    @Override
    public String loginOwner(UserName userName, Password password)
    {
        try {
            return rmiClient.loginOwner(userName, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return "Connection failed";
    }

    @Override
    public String loginStaff(UserName userName, Password password)
    {
        try {
            return rmiClient.loginStaff(userName, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return "Connection failed";
    }

    @Override
    public boolean authenticate()
    {
        try {
            return rmiClient.authenticate();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }
}
