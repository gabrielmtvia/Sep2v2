package main.client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.client.view.client.login.ClientLoginController;
import main.client.view.main.MainController;
import main.client.view.owner.login.OwnerLoginController;
import main.client.view.staff.login.StaffLoginController;
import main.client.view.staff.login.StaffLoginViewModel;


import java.io.IOException;

public class ViewHandler {

    private ViewModelFactory viewModelFactory;
    private Stage mainStage;
    private Scene clientLoginScene;
    private Scene ownerLoginScene;
    private Scene staffLoginScene;


    public ViewHandler(Stage stage, ViewModelFactory vmf)
    {
        mainStage = stage;
        viewModelFactory = vmf;
    }

    private Parent getRootByPath(String path, FXMLLoader loader)
    {
        loader.setLocation(getClass().getResource(path));
        Parent root = null;

        try
        {
            root = loader.load();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return root;
    }


    public void start(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/main/main.fxml"));
            Parent root = loader.load();
            MainController controller = loader.getController();
            controller.init(viewModelFactory.getMainViewModel(), this);
            Scene scene = new Scene(root);
            mainStage.setTitle("Gym System");

            mainStage.setScene(scene);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openClientLogin()
    {
        FXMLLoader loader = new FXMLLoader();

        if(clientLoginScene == null)
        {
            Parent root = getRootByPath("../view/client/login/clientlogin.fxml", loader);
            ClientLoginController controller = loader.getController();
            controller.init(viewModelFactory.getClientLoginViewModel(), this);
            clientLoginScene = new Scene(root);
        }

        mainStage.setTitle("Client Login");
        mainStage.setScene(clientLoginScene);
    }

    public void openOwnerLogin()
    {
        FXMLLoader loader = new FXMLLoader();

        if(ownerLoginScene == null)
        {
            Parent root = getRootByPath("../view/owner/login/ownerlogin.fxml", loader);
            OwnerLoginController controller = loader.getController();
            controller.init(viewModelFactory.getOwnerLoginViewModel(), this);
            clientLoginScene = new Scene(root);
        }

        mainStage.setTitle("Owner Login");
        mainStage.setScene(clientLoginScene);
    }


    public void openStaffLogin() {
        FXMLLoader loader = new FXMLLoader();

        if(staffLoginScene == null)
        {
            Parent root = getRootByPath("../view/staff/login/stafflogin.fxml", loader);
            StaffLoginController controller = loader.getController();
            controller.init(viewModelFactory.getStaffLoginViewModel(), this);
            staffLoginScene = new Scene(root);
        }

        mainStage.setTitle("Staff Login");
        mainStage.setScene(staffLoginScene);
    }
}

