package main.server.model.managestaff;

import main.server.databaseaccess.managestaff.ManageStaffDAOModel;
import main.shared.StaffMember;

import java.util.ArrayList;

public class ManageStaffManager implements ManageStaffModel{

    private ManageStaffDAOModel manageStaffDAO;

    public ManageStaffManager(ManageStaffDAOModel manageStaffDAO){
        this.manageStaffDAO = manageStaffDAO;
    }
    @Override
    public String addStaffMember(StaffMember staffMember) {
        return manageStaffDAO.addStaffMember(staffMember);
    }

    @Override
    public ArrayList<StaffMember> getStaffMembers() {
        return manageStaffDAO.getStaffMembers();
    }

    @Override
    public String deleteStaffMember(StaffMember staffMember) {
        return manageStaffDAO.deleteStaffMember(staffMember);
    }
}
