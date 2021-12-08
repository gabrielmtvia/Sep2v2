package main.client.networking.rmi;

import main.server.rmiserver.RemoteServer;
import main.shared.*;

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
    public String deleteActivity(Activity activity) throws RemoteException {
        return serverStub.deleteActivity(activity);
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
    public void addListener(String eventName, PropertyChangeListener listener) throws RemoteException{
        if(eventName == null || "".equals(eventName)) {
            support.addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(eventName, listener);
        }
    }

    @Override
    public boolean authenticate() throws RemoteException {
        if(serverStub==null){
        }
         else {
            try{
                serverStub.authenticate(this);
                System.out.println("System authenticated");
                return true;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public String saveBmiData(BMIData bmiData) throws RemoteException {
        return serverStub.saveBmiData(bmiData);
    }

    @Override
    public String addStaffMember(StaffMember staffMember) throws RemoteException {
        try {
            return serverStub.addStaffMember(staffMember);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Connection error";
    }

    @Override
    public ArrayList<StaffMember> getStaffMembers() throws RemoteException {
        try {
            return serverStub.getStaffMembers();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteStaffMember(StaffMember staffMember) throws RemoteException {
        try {
            return serverStub.deleteStaffMember(staffMember);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Connection error";
    }

    @Override
    public String savePersonalTrainer(PersonalTrainer personalTrainer) {
        try {
            return serverStub.savePersonalTrainer(personalTrainer);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Connection error";
    }

    @Override
    public ArrayList<PersonalTrainer> getPersonalTrainers() throws RemoteException {
        try {
            return serverStub.getPersonalTrainers();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String removePersonalTrainer(PersonalTrainer personalTrainer) throws RemoteException {
        try {
            return serverStub.removePersonalTrainer(personalTrainer);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Connection error";
    }

    @Override
    public void personalTrainerAdded(PersonalTrainer personalTrainer) throws RemoteException {
        support.firePropertyChange("Personal Trainer Added", null, personalTrainer);
    }

    @Override
    public void personalTrainerRemoved(PersonalTrainer personalTrainer) throws RemoteException {
        support.firePropertyChange("Personal Trainer Removed", null, personalTrainer);
    }

    @Override
    public void staffMemberAdded(StaffMember staffMember) throws RemoteException {
        support.firePropertyChange("Staff Member Added", null, staffMember);
    }

    @Override
    public void staffMemberDeleted(StaffMember staffMember) throws RemoteException {
        support.firePropertyChange("Staff Member Deleted", null, staffMember);
    }

    @Override public String saveClient(TheClient theClient) throws RemoteException
    {
        try {
            return serverStub.saveClient(theClient);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Connection error";
    }

    @Override public void clientAdded(TheClient theClient) throws RemoteException
    {
        support.firePropertyChange("Client Added", null, theClient);
    }

    @Override public void clientRemoved(TheClient theClient) throws RemoteException
    {
        support.firePropertyChange("Client Removed", null, theClient);
    }

    @Override public ArrayList<TheClient> getClients() throws RemoteException
    {
        try {
            return serverStub.getClients();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override public String removeClient(TheClient theClient) throws RemoteException
    {
        try {
            return serverStub.removeClient(theClient);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Connection error";
    }

    @Override
    public String registerActivities(Activity activity) throws RemoteException {
        return null;
    }
}
