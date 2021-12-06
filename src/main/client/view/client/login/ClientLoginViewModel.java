package main.client.view.client.login;
import javafx.beans.property.SimpleStringProperty;
import main.client.core.ViewHandler;
import main.client.model.login.LoginModel;
import main.shared.Password;
import main.shared.UserName;



public class ClientLoginViewModel {
    private SimpleStringProperty systemMessage;
    private LoginModel loginManager;
    private ViewHandler viewHandler;

    public ClientLoginViewModel(LoginModel loginManager) {
        systemMessage = new SimpleStringProperty();
        this.loginManager = loginManager;

    }

    public void setVH(ViewHandler viewHandler){
        this.viewHandler = viewHandler;
    }


    public SimpleStringProperty getSystemMessage(){return systemMessage;}

    public void login(UserName userName, Password password){
        String response = loginManager.loginClient(userName, password);
        systemMessage.setValue(response);

        if(response.contains("Successfully")){
            systemMessage.setValue("");
            viewHandler.openClientMain();
        }
    }
}
