package main.client.view.staff.login;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.client.core.ViewHandler;
import main.shared.Password;
import main.shared.UserName;

public class StaffLoginController
{
    @FXML private PasswordField password;
    @FXML private TextField username;
    @FXML private Label systemMessage;

    private StaffLoginViewModel staffLoginViewModel;
    private ViewHandler viewHandler;

    public void init(StaffLoginViewModel staffLoginViewModel, ViewHandler viewHandler)
    {
        this.staffLoginViewModel = staffLoginViewModel;
        this.viewHandler = viewHandler;
        systemMessage.textProperty().bindBidirectional(staffLoginViewModel.getSystemMessage());
        staffLoginViewModel.setViewHandler(viewHandler);
        username.requestFocus();
    }

    public void onLoginButton()
    {
        try {
            UserName userName = new UserName(username.getText());
            Password password2 = new Password(password.getText());
            staffLoginViewModel.login(userName,password2);
            username.setText("");
            password.setText("");
            username.requestFocus();
        } catch (Exception e){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }

    }

    public void onButtonBack()
    {
        viewHandler.start();
    }
}
