package main.server.rmiserver;

import main.client.networking.rmi.RemoteClient;
import main.server.core.ModelFactory;
import main.shared.Activity;
import main.shared.BMIData;
import main.shared.Password;
import main.shared.UserName;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class RmiServer implements RemoteServer{

    private ModelFactory modelFactory;
    private ArrayList<RemoteClient> clients;

    public RmiServer(ModelFactory modelFactory){

        this.modelFactory = modelFactory;
        clients = new ArrayList<>();

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            Naming.rebind("DB", this);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String LoginClient(UserName userName, Password password) throws RemoteException {
        return modelFactory.getLoginManager().validateLoginClient(userName, password);
    }

    @Override
    public String LoginOwner(UserName userName, Password password) throws RemoteException {
        return modelFactory.getLoginManager().validateLoginOwner(userName, password);
    }

    @Override
    public String LoginStaff(UserName userName, Password password) throws RemoteException {
        return modelFactory.getLoginManager().validateLoginStaff(userName, password);
    }

    @Override
    public ArrayList<Activity> requestActivities() throws RemoteException {
        return modelFactory.getActivitiesManager().requestActivities();
    }

    @Override
    public void deleteActivity(Activity activity) throws RemoteException {
        modelFactory.getActivitiesManager().deleteActivity(activity);

        for (RemoteClient client: clients) {
            client.activityDeleted(activity);
        }

    }

    @Override
    public String saveActivity(Activity activity) throws RemoteException {

        for (RemoteClient client: clients) {
            client.activityAdded(activity);
        }

        return modelFactory.getActivitiesManager().saveActivity(activity);
    }

    @Override
    public void authenticate(RemoteClient client) {
        if(!clients.contains(client)){
            clients.add(client);
        }
    }

    @Override
    public String saveBmiData(BMIData bmiData) throws RemoteException {
        return modelFactory.getBmiManager().saveBmiData(bmiData);
    }
}
