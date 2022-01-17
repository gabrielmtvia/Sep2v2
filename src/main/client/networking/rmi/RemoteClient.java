package main.client.networking.rmi;

import main.shared.*;

import java.beans.PropertyChangeListener;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteClient extends Remote
{
    String loginClient(UserName userName, Password password) throws RemoteException;
    String loginOwner(UserName userName, Password password) throws RemoteException;
    String loginStaff(UserName userName, Password password) throws RemoteException;
    ArrayList<Activity> requestActivities() throws RemoteException;
    String deleteActivity(Activity activity) throws RemoteException;
    String saveActivity(Activity activity) throws RemoteException;
    void activityDeleted(Activity activity) throws RemoteException;
    void activityAdded(Activity activity) throws RemoteException;
    void addListener(String eventName, PropertyChangeListener listener) throws RemoteException;
    boolean authenticate() throws RemoteException;
    String saveBmiData(BMIData bmiData) throws RemoteException;
    String addStaffMember(StaffMember staffMember) throws RemoteException;
    ArrayList<StaffMember> getStaffMembers() throws RemoteException;
    String deleteStaffMember(StaffMember staffMember) throws RemoteException;
    String savePersonalTrainer(PersonalTrainer personalTrainer) throws RemoteException;
    ArrayList<PersonalTrainer> getPersonalTrainers(boolean staff) throws RemoteException;
    String removePersonalTrainer(PersonalTrainer personalTrainer) throws RemoteException;
    void personalTrainerAdded(PersonalTrainer personalTrainer) throws RemoteException;
    void personalTrainerRemoved(PersonalTrainer personalTrainer) throws RemoteException;
    void staffMemberAdded(StaffMember staffMember) throws RemoteException;
    void staffMemberDeleted(StaffMember staffMember) throws RemoteException;
    String saveClient(TheClient theClient) throws RemoteException;
    void clientAdded(TheClient theClient) throws RemoteException;
    void clientRemoved(TheClient theClient) throws RemoteException;
    ArrayList<TheClient> getClients() throws RemoteException;
    String removeClient(TheClient theClient) throws RemoteException;
    BMIData loadBmiData(UserName userName) throws RemoteException;
    String deleteBmiData(UserName userName) throws RemoteException;
    String bookPersonalTrainer(PersonalTrainer personalTrainer, UserName userName) throws RemoteException;
    ArrayList<PersonalTrainer> viewMyBookings(UserName userName) throws RemoteException;
    void personalTrainerBooked(PersonalTrainer personalTrainer) throws RemoteException;
    void personalTrainerCancelled(PersonalTrainer personalTrainer) throws RemoteException;
    void personalTrainerAlreadyBooked(PersonalTrainer personalTrainer) throws RemoteException;
    String registerActivities(Activity activity, UserName userName) throws RemoteException;

    void activityRegistered() throws RemoteException;

    String cancelBooking(PersonalTrainer personalTrainer, UserName userName) throws RemoteException;
    void personalTrainerAlreadyCancelled(PersonalTrainer pt) throws RemoteException;
    ArrayList<Activity> requestRegisteredActivities(UserName userName) throws RemoteException;
    String cancelRegistration(Activity activity, UserName userName) throws RemoteException;
}
