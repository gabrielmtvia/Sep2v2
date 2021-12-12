package main.server.model.managestaff;

import main.shared.StaffMember;

import java.util.ArrayList;

public interface ManageStaffModel
{
    String addStaffMember(StaffMember staffMember);
    ArrayList<StaffMember> getStaffMembers();
    String deleteStaffMember(StaffMember staffMember);
}
