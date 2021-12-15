package main.server.databaseaccess.managestaff;

import main.server.databaseaccess.database.DBConnectionModel;
import main.shared.StaffMember;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManageStaffDAO implements ManageStaffDAOModel
{
    private DBConnectionModel dbConnection;

    public ManageStaffDAO(DBConnectionModel dbConnection)
    {
        this.dbConnection = dbConnection;
    }

    @Override
    public String addStaffMember(StaffMember staffMember)
    {
        PreparedStatement statement;

        try {
            String query = "INSERT INTO staff (ssn, fullname, username, password) VALUES (?,?,?,?)";
            statement = dbConnection.createPreparedStatement(query);
            statement.setString(1, staffMember.getSSN());
            statement.setString(2, staffMember.getFullName());
            statement.setString(3, staffMember.getUserName());
            statement.setString(4, staffMember.getPassword());
            statement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            dbConnection.closeConnection();
        }

        return "Staff Member added successfully";
    }

    @Override
    public ArrayList<StaffMember> getStaffMembers()
    {
        ArrayList<StaffMember> staffMembers = new ArrayList<>();
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            String query = "SELECT * FROM staff";
            statement = dbConnection.createPreparedStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                StaffMember staffMember = new StaffMember(resultSet.getString("ssn"), resultSet.getString("fullname"), resultSet.getString("username"), resultSet.getString("password"));
                staffMembers.add(staffMember);
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            dbConnection.closeConnection();
        }

        return staffMembers;
    }

    @Override
    public String deleteStaffMember(StaffMember staffMember)
    {
        PreparedStatement statement;

        try {
            String query = "DELETE FROM staff WHERE ssn = ?";
            statement = dbConnection.createPreparedStatement(query);
            statement.setString(1, staffMember.getSSN());
            statement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            dbConnection.closeConnection();
        }

        return "Staff member deleted successfully";
    }
}
