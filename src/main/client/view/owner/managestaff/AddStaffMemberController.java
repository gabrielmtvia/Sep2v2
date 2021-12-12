package main.client.view.owner.managestaff;

import javafx.scene.control.TextField;
import main.client.core.ViewHandler;

public class AddStaffMemberController
{
    public TextField ssn;
    public TextField fullname;
    public TextField username;
    public TextField password;

    private AddStaffMemberViewModel addAStaffMemberViewModel;
    private ViewHandler viewHandler;

    public void init(AddStaffMemberViewModel addAStaffMemberViewModel, ViewHandler viewHandler)
    {
        this.addAStaffMemberViewModel = addAStaffMemberViewModel;
        this.viewHandler = viewHandler;

        ssn.textProperty().bindBidirectional(addAStaffMemberViewModel.ssnProperty());
        fullname.textProperty().bindBidirectional(addAStaffMemberViewModel.fullnameProperty());
        username.textProperty().bindBidirectional(addAStaffMemberViewModel.usernameProperty());
        password.textProperty().bindBidirectional(addAStaffMemberViewModel.passwordProperty());
    }

    public void onSaveButton()
    {
        if(addAStaffMemberViewModel.addAStaffMember())
        {
                ssn.textProperty().set("");
                fullname.textProperty().set("");
                username.textProperty().set("");
                password.textProperty().set("");
        }
    }

    public void onBackButton()
    {
        viewHandler.openOwnerMain();
    }
}
