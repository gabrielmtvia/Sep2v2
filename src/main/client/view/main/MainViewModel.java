package main.client.view.main;

import javafx.scene.control.Alert;
import main.client.model.login.LoginModel;

public class MainViewModel
{
    private LoginModel loginManager;

    public MainViewModel(LoginModel loginManager)
    {
        this.loginManager = loginManager;
    }

    public void authenticate()
    {
        if(!loginManager.authenticate()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("CONNECTION ERROR");
            alert.setContentText("Failed to connect to the RMI Server");
            alert.showAndWait();
        }
    }
}
