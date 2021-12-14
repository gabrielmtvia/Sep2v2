package main.server.databaseaccess.managestaff;

import main.server.databaseaccess.database.DBConnectionModel;
import main.shared.StaffMember;

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

        try
        {
            String query = "INSERT INTO staff (ssn, fullname, username, password) VALUES (?,?,?,?)";
            statement = dbConnection.createPreparedStatement(query);
            statement.setString(1 ,staffMember.getSSN());
            statement.setString(2, staffMember.getFullName());
            statement.setString(3, staffMember.getUserName());
            statement.setString(4, staffMember.getPassword());
            statement.executeUpdate();
        }
        catch (Exception throwables)
        {
            throwables.printStackTrace();
        }
        return "Staff-Member added successfully";
    }

    @Override
    public ArrayList<StaffMember> getStaffMembers()
    {
        PreparedStatement statement;
        ResultSet resultSet;
        ArrayList<StaffMember> list = new ArrayList<>();

        try
        {
            String query = "SELECT * FROM staff";
            statement = dbConnection.createPreparedStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                StaffMember staffMember = new StaffMember(resultSet.getString("ssn"), resultSet.getString("fullname"), resultSet.getString("username"), resultSet.getString("password"));
                list.add(staffMember);
            }
        }
        catch (Exception throwables)
        {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public String deleteStaffMember(StaffMember staffMember)
    {
        PreparedStatement statement;

        try
        {
            String query = "DELETE FROM staff WHERE username = ?";
            statement = dbConnection.createPreparedStatement(query);
            statement.setString(1, staffMember.getUserName());
            statement.executeUpdate();
        }
        catch (Exception throwables)
        {
            throwables.printStackTrace();
        }
        return "Staff-Member deleted successfully";
    }
}
