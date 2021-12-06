package main.client.view.owner.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.client.core.ViewHandler;
import main.shared.Password;
import main.shared.UserName;

public class OwnerLoginController {
    @FXML
    private Label systemMessage;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    private Button login;

    private OwnerLoginViewModel ownerLoginViewModel;
    private ViewHandler viewHandler;


    public void init(OwnerLoginViewModel ownerLoginViewModel, ViewHandler viewHandler){
        this.ownerLoginViewModel = ownerLoginViewModel;
        this.viewHandler = viewHandler;
        systemMessage.textProperty().bindBidirectional(ownerLoginViewModel.getSystemMessage());
        ownerLoginViewModel.setViewHandler(viewHandler);
        username.requestFocus();

    }

    public void onLoginButton(ActionEvent actionEvent) {
        UserName userName = new UserName(username.getText());
        Password password2 = new Password(password.getText());
        ownerLoginViewModel.login(userName,password2);
        username.setText("");
        password.setText("");
        username.requestFocus();
    }

    public void onButtonBack(ActionEvent actionEvent) {
        viewHandler.start();
    }
}
