package main.client.networking.managestaff;

import main.client.networking.rmi.RemoteClient;
import main.shared.StaffMember;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ManageStaffClient implements ManageStaffClientModel{

    private RemoteClient rmiClient;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ManageStaffClient(RemoteClient rmiClient){
        this.rmiClient = rmiClient;
        try {
            rmiClient.addListener("Staff Member Added", evt -> staffMemberAdded(evt));
            rmiClient.addListener("Staff Member Deleted", evt -> staffMemberDeleted(evt));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void staffMemberAdded(PropertyChangeEvent evt) {
        StaffMember staffMemberAdded = (StaffMember) evt.getNewValue();
        support.firePropertyChange("Staff Member Added", null, staffMemberAdded);
    }

    private void staffMemberDeleted(PropertyChangeEvent evt) {
        StaffMember staffMemberDeleted = (StaffMember) evt.getNewValue();
        support.firePropertyChange("Staff Member Deleted", null, staffMemberDeleted);
    }

    @Override
    public String addStaffMember(StaffMember staffMember) {
        try {
            return rmiClient.addStaffMember(staffMember);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Connection Error";
    }

    @Override
    public ArrayList<StaffMember> getStaffMembers() {
        try {
            return rmiClient.getStaffMembers();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteStaffMember(StaffMember staffMember) {
        try {
            return rmiClient.deleteStaffMember(staffMember);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Connection Error";
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)) {
            support.addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(eventName, listener);
        }
    }
}
