package main.client.networking.managestaff;

import main.shared.StaffMember;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface ManageStaffClientModel {
    String addStaffMember(StaffMember staffMember);
    ArrayList<StaffMember> getStaffMembers();
    String deleteStaffMember(StaffMember staffMember);
    void addListener(String eventName, PropertyChangeListener listener);
}
