package main.client.view.main;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.client.core.ViewHandler;

public class MainController {
    @FXML
    private Button client;
    @FXML
    private Button staff;
    @FXML
    private Button owner;

    private ViewHandler viewHandler;
    private MainViewModel mainViewModel;

    public void init(MainViewModel mainViewModel, ViewHandler viewHandler){
        this.mainViewModel = mainViewModel;
        this.viewHandler = viewHandler;
    }


    public void onClientButton(ActionEvent actionEvent) {
        viewHandler.openClientLogin();
    }

    public void onStaffButton(ActionEvent actionEvent) {
        //viewHandler.openStaffLogin();
    }

    public void onOwnerButton(ActionEvent actionEvent) {
        //viewHandler.openOwnerLogin();
    }
}
