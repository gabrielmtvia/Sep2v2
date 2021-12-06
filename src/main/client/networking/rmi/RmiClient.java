package main.client.networking.rmi;

import main.server.rmiserver.RemoteServer;
import main.shared.Activity;
import main.shared.BMIData;
import main.shared.Password;
import main.shared.UserName;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiClient implements RemoteClient {

    private RemoteServer serverStub;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public RmiClient(){
        try{
            serverStub = (RemoteServer) Naming.lookup("rmi://localhost:1099/DB");
            UnicastRemoteObject.exportObject(this,0);
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String loginClient(UserName userName, Password password) throws RemoteException {
        return serverStub.LoginClient(userName, password);
    }

    @Override
    public String loginOwner(UserName userName, Password password) throws RemoteException {
        return serverStub.LoginOwner(userName, password);
    }

    @Override
    public String loginStaff(UserName userName, Password password) throws RemoteException {
        return serverStub.LoginStaff(userName, password);
    }

    @Override
    public ArrayList<Activity> requestActivities() throws RemoteException {
        return serverStub.requestActivities();
    }

    @Override
    public void deleteActivity(Activity activity) throws RemoteException {
        serverStub.deleteActivity(activity);
    }

    @Override
    public String saveActivity(Activity activity) throws RemoteException {
        return serverStub.saveActivity(activity);
    }

    @Override
    public void activityDeleted(Activity activity) throws RemoteException {
        support.firePropertyChange("Activity Deleted", null, activity);
    }

    @Override
    public void activityAdded(Activity activity) throws RemoteException {
        support.firePropertyChange("Activity Added", null, activity);
    }


    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)) {
            support.addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(eventName, listener);
        }
    }

    @Override
    public void authenticate() throws RemoteException {
        serverStub.authenticate(this);
        System.out.println("System authenticated");
    }

    @Override
    public void saveBmiData(BMIData bmiData) throws RemoteException {
        serverStub.saveBmiData(bmiData);
    }
}
