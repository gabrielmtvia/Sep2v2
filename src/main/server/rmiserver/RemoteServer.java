package main.server.rmiserver;

import main.client.networking.rmi.RemoteClient;
import main.shared.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteServer extends Remote {
    String LoginClient(UserName userName, Password password) throws RemoteException;
    String LoginOwner(UserName userName, Password password) throws RemoteException;
    String LoginStaff(UserName userName, Password password) throws RemoteException;
    ArrayList<Activity> requestActivities() throws RemoteException;
    String deleteActivity(Activity activity) throws RemoteException;
    String saveActivity(Activity activity) throws RemoteException;
    boolean authenticate(RemoteClient client) throws RemoteException;
    String saveBmiData(BMIData bmiData) throws RemoteException;
    String addStaffMember(StaffMember staffMember) throws RemoteException;
    ArrayList<StaffMember> getStaffMembers() throws RemoteException;
    String deleteStaffMember(StaffMember staffMember) throws RemoteException;
    String savePersonalTrainer(PersonalTrainer personalTrainer) throws RemoteException;
    ArrayList<PersonalTrainer> getPersonalTrainers() throws RemoteException;
    String removePersonalTrainer(PersonalTrainer personalTrainer) throws RemoteException;
    String saveClient(TheClient theClient) throws RemoteException;
    ArrayList<TheClient> getClients() throws RemoteException;
    String removeClient(TheClient theClient) throws RemoteException;

    BMIData loadBmiData(UserName userName) throws  RemoteException;
    String deleteBmiData(UserName userName) throws RemoteException;

    String bookPersonalTrainer(PersonalTrainer personalTrainer, UserName userName) throws RemoteException;
}
