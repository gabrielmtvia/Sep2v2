package main.client.model.managestaff;

import main.client.networking.managestaff.ManageStaffClientModel;
import main.shared.StaffMember;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ManageStaffManager implements ManageStaffModel
{
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private ManageStaffClientModel manageStaffClient;

    public ManageStaffManager(ManageStaffClientModel manageStaffClient)
    {
        this.manageStaffClient = manageStaffClient;

        manageStaffClient.addListener("Staff Member Added", evt -> staffMemberAdded(evt));
        manageStaffClient.addListener("Staff Member Deleted", evt -> staffMemberDeleted(evt));
    }

    private void staffMemberAdded(PropertyChangeEvent evt)
    {
        StaffMember staffMemberAdded = (StaffMember) evt.getNewValue();
        support.firePropertyChange("Staff Member Added", null, staffMemberAdded);
    }

    private void staffMemberDeleted(PropertyChangeEvent evt)
    {
        StaffMember staffMemberDeleted = (StaffMember) evt.getNewValue();
        support.firePropertyChange("Staff Member Deleted", null, staffMemberDeleted);
    }

    @Override
    public String addStaffMember(StaffMember staffMember)
    {
        return manageStaffClient.addStaffMember(staffMember);
    }

    @Override
    public ArrayList<StaffMember> getStaffMembers()
    {
        return manageStaffClient.getStaffMembers();
    }

    @Override
    public String deleteStaffMember(StaffMember staffMember)
    {
        return manageStaffClient.deleteStaffMember(staffMember);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener)
    {
        if(eventName == null || "".equals(eventName)) {
            support.addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(eventName, listener);
        }
    }
}
