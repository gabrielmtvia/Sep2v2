package main.client.view.owner.staffmemberlist;
import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import main.client.model.managestaff.ManageStaffModel;
import main.shared.StaffMember;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;


public class StaffMemberListViewModel {
    private ManageStaffModel manageStaffManager;
    private String staffMember;
    private SimpleListProperty staffMembersList;
    private ObservableList<String> list = FXCollections.observableArrayList();

    public StaffMemberListViewModel(ManageStaffModel manageStaffManager) {
        this.manageStaffManager = manageStaffManager;
        manageStaffManager.addListener("Staff Member Added", evt -> staffMemberAdded(evt));
        manageStaffManager.addListener("Staff Member Deleted", evt -> staffMemberDeleted(evt));
        staffMembersList = new SimpleListProperty();
    }

    private void staffMemberAdded(PropertyChangeEvent evt) {
        StaffMember staffMemberAdded = (StaffMember) evt.getNewValue();
        list.add(staffMemberAdded.toString());
        staffMembersList.setValue(list);
    }

    private void staffMemberDeleted(PropertyChangeEvent evt) {
        StaffMember staffMemberDeleted = (StaffMember) evt.getNewValue();
        Platform.runLater(()->list.remove(staffMemberDeleted.toString()));
        staffMembersList.setValue(list);
    }


    public void populateList(){
        ArrayList<StaffMember> test = getStaffMembers();

        if(test==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setContentText("Connection error");
            alert.showAndWait();
        }
        else{
            for (StaffMember staffMember:
                    test) {
                list.add(staffMember.toString());
            }
            staffMembersList.setValue(list);
        }

    }

    public ArrayList<StaffMember> getStaffMembers(){
        return manageStaffManager.getStaffMembers();
    }

    public SimpleListProperty getStaffMembersList(){
        return staffMembersList;
    }

    public void deleteStaffMember(StaffMember staffMember){
        String response = manageStaffManager.deleteStaffMember(staffMember);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Deleting a Staff Member");
        alert.setContentText(response);
        alert.showAndWait();
    }
}
