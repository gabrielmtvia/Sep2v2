package main.client.view.owner.staffmemberlist;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import main.client.core.ViewHandler;
import main.shared.StaffMember;

import java.util.ArrayList;


public class StaffMemberListController {

    StaffMemberListViewModel staffMemberListViewModel;
    ViewHandler viewHandler;

    @FXML
    private ListView staffMembersList;


    public void init(StaffMemberListViewModel staffMemberListViewModel, ViewHandler viewHandler){
        this.staffMemberListViewModel = staffMemberListViewModel;
        this.viewHandler = viewHandler;

        staffMembersList.itemsProperty().bindBidirectional(staffMemberListViewModel.getStaffMembersList());
        staffMemberListViewModel.populateList();
    }

    public void onDeleteButton(ActionEvent actionEvent) {
        ObservableList selectedIndices = staffMembersList.getSelectionModel().getSelectedIndices();
        Object[] array = selectedIndices.toArray();
        int position = (int) array[0];

        ArrayList<StaffMember> staffMemberArrayList = staffMemberListViewModel.getStaffMembers();
        StaffMember staffMember = staffMemberArrayList.get(position);

        staffMemberListViewModel.deleteStaffMember(staffMember);

    }

    public void onBackButton(ActionEvent actionEvent) {
        viewHandler.openOwnerMain();
    }
}
