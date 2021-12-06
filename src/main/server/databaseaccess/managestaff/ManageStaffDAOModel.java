package main.server.databaseaccess.managestaff;

import main.shared.StaffMember;

import java.util.ArrayList;

public interface ManageStaffDAOModel {
    String addStaffMember(StaffMember staffMember);
    ArrayList<StaffMember> getStaffMembers();
    String deleteStaffMember(StaffMember staffMember);
}
