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

        return serverStub.addStaffMember(staffMember);
    }

    @Override
    public ArrayList<StaffMember> getStaffMembers() throws RemoteException {

        return serverStub.getStaffMembers();

    }

    @Override
    public String deleteStaffMember(StaffMember staffMember) throws RemoteException {

        return serverStub.deleteStaffMember(staffMember);

    }

    @Override
    public String savePersonalTrainer(PersonalTrainer personalTrainer)  throws RemoteException{

        return serverStub.savePersonalTrainer(personalTrainer);

    }

    @Override
    public ArrayList<PersonalTrainer> getPersonalTrainers(boolean staff) throws RemoteException {
        return serverStub.getPersonalTrainers(staff);
    }

    @Override
    public String removePersonalTrainer(PersonalTrainer personalTrainer) throws RemoteException {
        return serverStub.removePersonalTrainer(personalTrainer);
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
        return serverStub.saveClient(theClient);
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
        return serverStub.getClients();
    }

    @Override public String removeClient(TheClient theClient) throws RemoteException
    {
        return serverStub.removeClient(theClient);
    }

    @Override
    public BMIData loadBmiData(UserName userName) throws RemoteException {
        return serverStub.loadBmiData(userName);
    }

    @Override
    public String deleteBmiData(UserName userName) throws RemoteException {
        return serverStub.deleteBmiData(userName);
    }

    @Override
    public String bookPersonalTrainer(PersonalTrainer personalTrainer, UserName userName) throws RemoteException {
        return serverStub.bookPersonalTrainer(personalTrainer, userName, this);
    }

    @Override
    public ArrayList<PersonalTrainer> viewMyBookings(UserName userName) throws RemoteException {
        return serverStub.viewMyBookings(userName);
    }

    @Override
    public void personalTrainerBooked(PersonalTrainer personalTrainer) {
        support.firePropertyChange("Personal Trainer Booked", null, personalTrainer);
    }

    @Override
    public void personalTrainerCancelled(PersonalTrainer personalTrainer) {
        support.firePropertyChange("Personal Trainer Cancelled", null, personalTrainer);
    }

    @Override
    public void personalTrainerAlreadyBooked(PersonalTrainer personalTrainer) {
        support.firePropertyChange("Personal Trainer Already Booked", null, personalTrainer);
    }

    @Override
    public String cancelBooking(PersonalTrainer personalTrainer, UserName userName) throws RemoteException {
        return serverStub.cancelBooking(personalTrainer, userName, this);
    }

    @Override
    public ArrayList<Activity> requestRegisteredActivities() throws RemoteException {
        return serverStub.requestRegisteredActivities();
    }

    @Override
    public String registeredActivity(Activity activity, UserName userName) throws RemoteException {
        return serverStub.registeredActivity(activity, userName);


    }
}
