package main.client.view.client.login;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.core.ModelFactory;
import main.client.core.ViewHandler;
import main.client.model.login.LoginModel;
import main.shared.Password;
import main.shared.UserName;


import java.beans.PropertyChangeEvent;

public class ClientLoginViewModel {
    private SimpleStringProperty systemMessage;
    private LoginModel loginManager;
    private ViewHandler viewHandler;

    public ClientLoginViewModel(ModelFactory mf) {
        systemMessage = new SimpleStringProperty();
        this.loginManager = mf.getLoginManager();

    }

    public void setVH(ViewHandler viewHandler){
        this.viewHandler = viewHandler;
    }


    public SimpleStringProperty getSystemMessage(){return systemMessage;}

    public void login(UserName userName, Password password){
        String response = loginManager.LoginClient(userName, password);
        systemMessage.setValue(response);

        if(response.contains("Successfully")){
            systemMessage.setValue("");
            viewHandler.openClientMain();
        }
    }
}
