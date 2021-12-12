package main.client.view.owner.staffmemberlist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import main.client.model.managestaff.ManageStaffModel;
import main.shared.StaffMember;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class StaffMemberListViewModel
{
    private ManageStaffModel manageStaffManager;
    private ObservableList<StaffMember> list;

    public StaffMemberListViewModel(ManageStaffModel manageStaffManager)
    {
        this.manageStaffManager = manageStaffManager;

        list = FXCollections.observableArrayList();

        manageStaffManager.addListener("Staff Member Added", evt -> staffMemberAdded(evt));
        manageStaffManager.addListener("Staff Member Deleted", evt -> staffMemberDeleted(evt));

        populateList();
    }

    private void staffMemberAdded(PropertyChangeEvent evt)
    {
        StaffMember staffMemberAdded = (StaffMember) evt.getNewValue();
        list.add(staffMemberAdded);
    }

    private void staffMemberDeleted(PropertyChangeEvent evt)
    {
        StaffMember staffMemberDeleted = (StaffMember) evt.getNewValue();
        list.remove(staffMemberDeleted);
    }

    public void populateList()
    {
        ArrayList<StaffMember> test = getStaffMembers();
        System.out.println(test.toString());

        if(test==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setContentText("Connection error");
            alert.showAndWait();
        }
        else{
            list.addAll(test);
        }
    }

    public ObservableList<StaffMember> getList()
    {
        return list;
    }

    public void deleteStaffMember(StaffMember staffMember)
    {
        String response = manageStaffManager.deleteStaffMember(staffMember);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Deleting a Staff Member");
        alert.setContentText(response);
        alert.showAndWait();
    }

    public ArrayList<StaffMember> getStaffMembers()
    {
        return manageStaffManager.getStaffMembers();
    }
}
