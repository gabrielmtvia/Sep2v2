package main.client.view.owner.managestaff;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import main.client.model.managestaff.ManageStaffModel;
import main.shared.StaffMember;

public class AddStaffMemberViewModel {

    private ManageStaffModel manageStaffManager;
    private SimpleStringProperty ssn;
    private SimpleStringProperty fullname;
    private SimpleStringProperty username;
    private SimpleStringProperty password;

    public AddStaffMemberViewModel(ManageStaffModel manageStaffManager) {
        this.manageStaffManager = manageStaffManager;

        ssn = new SimpleStringProperty();
        fullname = new SimpleStringProperty();
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
    }

    public boolean addAStaffMember()
    {
        String response = "Please fill all the fields";

        if(getSsn()!=""&&getSsn()!=null&&getFullname()!=""&&getFullname()!=null&&getUsername()!=""&&getUsername()!=null&&getPassword()!=""&& getPassword()!=null){
            response = manageStaffManager.addStaffMember(new StaffMember(getSsn(),getFullname(),getUsername(),getPassword()));
            alert(response);
        } else {
            alert(response);
            return false;
        }

        return true;
    }

    public void alert(String response){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Adding a Staff Member");
        alert.setContentText(response);
        alert.showAndWait();
    }

    public String getSsn() {
        return ssn.get();
    }

    public SimpleStringProperty ssnProperty() {
        return ssn;
    }

    public String getFullname() {
        return fullname.get();
    }

    public SimpleStringProperty fullnameProperty() {
        return fullname;
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }
}
