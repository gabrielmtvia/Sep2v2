package main.client.view.owner.login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.core.ViewHandler;
import main.client.model.login.LoginModel;
import main.shared.Password;
import main.shared.UserName;

public class OwnerLoginViewModel
{
    private StringProperty systemMessage;
    private LoginModel loginManager;
    private ViewHandler viewHandler;

    public OwnerLoginViewModel(LoginModel loginManager)
    {
        this.loginManager = loginManager;
        systemMessage = new SimpleStringProperty();
    }

    public void setViewHandler(ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
    }

    public StringProperty getSystemMessage()
    {
        return systemMessage;
    }

    public void login(UserName userName, Password password)
    {
        String response = loginManager.loginOwner(userName, password);
        systemMessage.set(response);
        if(response.contains("Successfully")){
            systemMessage.set("");
            viewHandler.openOwnerMain();
        }
    }
}
