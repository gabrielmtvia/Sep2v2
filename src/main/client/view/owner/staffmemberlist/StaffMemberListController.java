package main.client.view.owner.staffmemberlist;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.client.core.ViewHandler;
import main.shared.StaffMember;

import java.util.ArrayList;


public class StaffMemberListController {

    @FXML private TableView tableView;
    @FXML private TableColumn SSN;
    @FXML private TableColumn fullName;
    @FXML private TableColumn userName;
    @FXML private TableColumn password;

    private StaffMemberListViewModel staffMemberListViewModel;
    private ViewHandler viewHandler;



    public void init(StaffMemberListViewModel staffMemberListViewModel, ViewHandler viewHandler){
        this.staffMemberListViewModel = staffMemberListViewModel;
        this.viewHandler = viewHandler;

        SSN.setCellValueFactory(new PropertyValueFactory<>("SSN"));
        fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));

        tableView.setItems(staffMemberListViewModel.getList());

    }

    public void onDeleteButton(ActionEvent actionEvent) {
        ObservableList selectedIndices = tableView.getSelectionModel().getSelectedIndices();
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
