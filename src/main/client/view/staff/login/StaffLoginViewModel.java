package main.client.view.staff.login;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.core.ModelFactory;
import main.client.core.ViewHandler;
import main.client.model.login.LoginModel;
import main.shared.Password;
import main.shared.UserName;


import java.beans.PropertyChangeEvent;

public class StaffLoginViewModel {
    private StringProperty systemMessage;
    private LoginModel loginManager;
    private ViewHandler viewHandler;

    public StaffLoginViewModel(ModelFactory mf) {
        systemMessage = new SimpleStringProperty();
        loginManager = mf.getLoginManager();
    }

    public void setViewHandler(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
    }


    public StringProperty getSystemMessage(){
        return systemMessage;
    }

    public void login(UserName userName, Password password){
        String response = loginManager.LoginStaff(userName, password);
        systemMessage.set(response);

        //Platform.runLater(()->viewHandler.openStaffMain()
    }

}
