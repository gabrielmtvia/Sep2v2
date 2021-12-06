package main.server.rmiserver;
import main.client.networking.rmi.RemoteClient;
import main.shared.Activity;
import main.shared.BMIData;
import main.shared.Password;
import main.shared.UserName;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteServer extends Remote {
    String LoginClient(UserName userName, Password password) throws RemoteException;
    String LoginOwner(UserName userName, Password password) throws RemoteException;
    String LoginStaff(UserName userName, Password password) throws RemoteException;
    ArrayList<Activity> requestActivities() throws RemoteException;
    void deleteActivity(Activity activity) throws RemoteException;
    String saveActivity(Activity activity) throws RemoteException;
    void authenticate(RemoteClient client) throws RemoteException;
    String saveBmiData(BMIData bmiData) throws RemoteException;
}
