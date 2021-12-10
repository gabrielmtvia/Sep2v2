package main.server.rmiserver;

import main.client.networking.rmi.RemoteClient;
import main.server.core.ModelFactory;
import main.shared.*;

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
    public String deleteActivity(Activity activity) throws RemoteException {

        for (RemoteClient client: clients) {
            client.activityDeleted(activity);
        }

        return modelFactory.getActivitiesManager().deleteActivity(activity);
    }

    @Override
    public String saveActivity(Activity activity) throws RemoteException {

        for (RemoteClient client: clients) {
            client.activityAdded(activity);
        }

        return modelFactory.getActivitiesManager().saveActivity(activity);
    }

    @Override
    public boolean authenticate(RemoteClient client) throws RemoteException{
        if(!clients.contains(client)){
            clients.add(client);
        }
        return true;
    }

    @Override
    public String saveBmiData(BMIData bmiData) throws RemoteException {
        return modelFactory.getBmiManager().saveBmiData(bmiData);
    }

    @Override
    public String addStaffMember(StaffMember staffMember) throws RemoteException{
        for (RemoteClient client: clients) {
            client.staffMemberAdded(staffMember);
        }
        return modelFactory.getManageStaffManager().addStaffMember(staffMember);
    }

    @Override
    public ArrayList<StaffMember> getStaffMembers() throws RemoteException {
        return modelFactory.getManageStaffManager().getStaffMembers();
    }

    @Override
    public String deleteStaffMember(StaffMember staffMember) throws RemoteException {
        for (RemoteClient client: clients) {
            client.staffMemberDeleted(staffMember);
        }
        return modelFactory.getManageStaffManager().deleteStaffMember(staffMember);
    }

    @Override
    public String savePersonalTrainer(PersonalTrainer personalTrainer) throws RemoteException{
        for (RemoteClient client: clients) {
            client.personalTrainerAdded(personalTrainer);
        }
        return modelFactory.getPersonalTrainerManager().savePersonalTrainer(personalTrainer);
    }

    @Override
    public ArrayList<PersonalTrainer> getPersonalTrainers(boolean staff) throws RemoteException {
        return modelFactory.getPersonalTrainerManager().getPersonalTrainers(staff);
    }

    @Override
    public String removePersonalTrainer(PersonalTrainer personalTrainer) throws RemoteException {
        for (RemoteClient client: clients) {
            client.personalTrainerRemoved(personalTrainer);
        }
        return modelFactory.getPersonalTrainerManager().removePersonalTrainer(personalTrainer);
    }

    @Override public String saveClient(TheClient theClient) throws RemoteException
    {
        for (RemoteClient client : clients)
        {
            client.clientAdded(theClient);
        }
        return modelFactory.getClientManager().saveClient(theClient);
    }

    @Override public ArrayList<TheClient> getClients() throws RemoteException
    {
        return modelFactory.getClientManager().getClients();
    }

    @Override public String removeClient(TheClient theClient) throws RemoteException
    {
        for (RemoteClient client: clients) {
            client.clientRemoved(theClient);
        }
        return modelFactory.getClientManager().removeClient(theClient);
    }

    @Override
    public BMIData loadBmiData(UserName userName) throws RemoteException {
        return modelFactory.getBmiManager().loadBmiData(userName);
    }

    @Override
    public String deleteBmiData(UserName userName) throws RemoteException {
        return modelFactory.getBmiManager().deleteBmiData(userName);
    }

    @Override
    public String bookPersonalTrainer(PersonalTrainer personalTrainer, UserName userName, RemoteClient remoteClient) throws RemoteException {

        remoteClient.personalTrainerBooked(personalTrainer);

        clients.remove(remoteClient);

        for (RemoteClient client : clients) {
                client.personalTrainerAlreadyBooked(personalTrainer);
            System.out.println("executed already booked for secondary client");
        }

        clients.add(remoteClient);
        return modelFactory.getPersonalTrainerManager().bookPersonalTrainer(personalTrainer, userName);
    }

    @Override
    public ArrayList<PersonalTrainer> viewMyBookings(UserName userName) throws RemoteException {
        return modelFactory.getPersonalTrainerManager().viewMyBookings(userName);
    }

    @Override
    public String cancelBooking(PersonalTrainer personalTrainer, UserName userName, RemoteClient remoteClient)  throws RemoteException{
        clients.remove(remoteClient);
        for (RemoteClient client : clients) {
           client.cancelBooking(personalTrainer, userName);
        }
        clients.add(remoteClient);
        remoteClient.personalTrainerRemoved(personalTrainer);
        PersonalTrainer pt = personalTrainer;
        pt.setUsername("");
        remoteClient.personalTrainerAdded(pt);
        return modelFactory.getPersonalTrainerManager().cancelBooking(personalTrainer, userName);
    }

    @Override
    public String registeredActivity(Activity activity, UserName userName)throws RemoteException {
        return modelFactory.getActivitiesManager().registeredActivity(activity, userName);
    }
}
