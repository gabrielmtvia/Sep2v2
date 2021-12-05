package main.server.rmiserver;

import main.shared.Password;
import main.shared.UserName;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteServer extends Remote {
    String LoginClient(UserName userName, Password password) throws RemoteException;
}
