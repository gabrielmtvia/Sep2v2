package main.client.view.owner.main;
import javafx.event.ActionEvent;
import main.client.core.ViewHandler;

public class OwnerMainController {

    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler){
        this.viewHandler = viewHandler;
    }

    public void onAddStaffMember(ActionEvent actionEvent) {
        viewHandler.openOwnerAddAStaffMember();
    }

    public void onStaffMembersList(ActionEvent actionEvent) {
        viewHandler.openOwnerStaffMembersList();
    }

    public void onBackButton(ActionEvent actionEvent) {
       viewHandler.openOwnerLogin();
    }
}
