package main.client.networking.rmi;

import main.server.rmiserver.RemoteServer;
import main.shared.Password;
import main.shared.PropertyChangeSubject;
import main.shared.UserName;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiClient implements RemoteClient, PropertyChangeSubject {

    private RemoteServer serverStub;
    private PropertyChangeSupport newActivitySupport = new PropertyChangeSupport(this);

    public RmiClient(){
        try{
            serverStub = (RemoteServer) Naming.lookup("rmi://localhost:1099/DB");
            UnicastRemoteObject.exportObject(this,0);
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String LoginClient(UserName userName, Password password) throws RemoteException {
        return serverStub.LoginClient(userName, password);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
