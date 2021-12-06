package main.server.databaseaccess.managestaff;

import main.server.databaseaccess.database.DBConnectionModel;
import main.shared.StaffMember;

import java.util.ArrayList;

public class ManageStaffDAO implements ManageStaffDAOModel{

    private DBConnectionModel dbConnection;

    public ManageStaffDAO(DBConnectionModel dbConnection){
        this.dbConnection = dbConnection;
    }

    @Override
    public String addStaffMember(StaffMember staffMember) {
        return "Staff Member added successfully";
    }

    @Override
    public ArrayList<StaffMember> getStaffMembers() {
        ArrayList<StaffMember> test = new ArrayList<>();
        test.add(new StaffMember("456", "test","test", "test"));
        test.add(new StaffMember("354", "dummy","test", "test"));
        test.add(new StaffMember("456", "test","dummy", "test"));
        test.add(new StaffMember("456", "test","test", "dummy"));

        return test;
    }

    @Override
    public String deleteStaffMember(StaffMember staffMember) {
        return "Staff member deleted successfully";
    }
}
