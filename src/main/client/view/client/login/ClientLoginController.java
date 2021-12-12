package main.client.view.client.login;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.client.core.ViewHandler;
import main.shared.Password;
import main.shared.UserName;

public class ClientLoginController
{
    @FXML private PasswordField password;
    @FXML private TextField username;
    @FXML private Label systemMessage;

    private ClientLoginViewModel clientLoginViewModel;
    private ViewHandler viewHandler;

    public void onLoginButton()
    {
        UserName userName = new UserName(username.getText());
        Password passWord = new Password(password.getText());
        clientLoginViewModel.login(userName,passWord);
        username.setText("");
        password.setText("");
        username.requestFocus();
    }

    public void init(ClientLoginViewModel clientLoginViewModel, ViewHandler viewHandler)
    {
        this.clientLoginViewModel = clientLoginViewModel;
        this.viewHandler = viewHandler;
        systemMessage.textProperty().bindBidirectional(clientLoginViewModel.getSystemMessage());
        clientLoginViewModel.setVH(viewHandler);
        username.requestFocus();
    }

    public void onButtonBack()
    {
        viewHandler.start();
    }
}
