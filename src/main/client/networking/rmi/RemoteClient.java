package main.client.networking.rmi;

import main.shared.Activity;
import main.shared.Password;
import main.shared.UserName;

import java.beans.PropertyChangeListener;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteClient extends Remote {
    String loginClient(UserName userName, Password password) throws RemoteException;
    String loginOwner(UserName userName, Password password) throws RemoteException;
    String loginStaff(UserName userName, Password password) throws RemoteException;
    ArrayList<Activity> requestActivities() throws RemoteException;
    void deleteActivity(Activity activity) throws RemoteException;
    String saveActivity(Activity activity) throws RemoteException;
    void activityDeleted(Activity activity) throws RemoteException;
    void activityAdded(Activity activity) throws RemoteException;
    void addListener(String eventName, PropertyChangeListener listener) throws RemoteException;
    void authenticate() throws RemoteException;
}
