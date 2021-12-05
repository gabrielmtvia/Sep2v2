package main.client.networking.rmi;

import main.shared.Password;
import main.shared.UserName;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteClient extends Remote {
    String LoginClient(UserName userName, Password password) throws RemoteException;
}
