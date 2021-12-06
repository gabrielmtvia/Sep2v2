package main.client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.client.view.client.activities.ActivitiesController;
import main.client.view.client.login.ClientLoginController;
import main.client.view.client.main.ClientMainController;
import main.client.view.main.MainController;
import main.client.view.owner.login.OwnerLoginController;
import main.client.view.owner.main.OwnerMainController;
import main.client.view.staff.login.StaffLoginController;
import main.client.view.staff.login.StaffLoginViewModel;
import main.client.view.staff.main.StaffMainController;


import java.io.IOException;

public class ViewHandler {

    private ViewModelFactory viewModelFactory;
    private Stage mainStage;
    private Scene clientLoginScene;
    private Scene ownerLoginScene;
    private Scene staffLoginScene;
    private Scene clientMainScene;
    private Scene ownerMainScene;
    private Scene staffMainScene;
    private Scene clientActivities;


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
            ownerLoginScene = new Scene(root);
        }

        mainStage.setTitle("Owner Login");
        mainStage.setScene(ownerLoginScene);
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

    public void openClientMain() {
        FXMLLoader loader = new FXMLLoader();

        if(clientMainScene == null)
        {
            Parent root = getRootByPath("../view/client/main/clientmain.fxml", loader);
            ClientMainController controller = loader.getController();
            controller.init( this);
            clientMainScene = new Scene(root);
        }

        mainStage.setTitle("Client Main Window");
        mainStage.setScene(clientMainScene);
    }

    public void openOwnerMain() {
        FXMLLoader loader = new FXMLLoader();

        if(ownerMainScene == null)
        {
            Parent root = getRootByPath("../view/owner/main/ownermain.fxml", loader);
            OwnerMainController controller = loader.getController();
            controller.init( this);
            ownerMainScene = new Scene(root);
        }

        mainStage.setTitle("Owner Main Window");
        mainStage.setScene(ownerMainScene);
    }

    public void openStaffMain() {
        FXMLLoader loader = new FXMLLoader();

        if(staffMainScene == null)
        {
            Parent root = getRootByPath("../view/staff/main/staffmain.fxml", loader);
            StaffMainController controller = loader.getController();
            controller.init( this);
            staffMainScene = new Scene(root);
        }

        mainStage.setTitle("Staff Main Window");
        mainStage.setScene(staffMainScene);
    }

    public void openClientActivities() {
        FXMLLoader loader = new FXMLLoader();

        if(clientActivities == null)
        {
            Parent root = getRootByPath("../view/client/activities/activities.fxml", loader);
            ActivitiesController controller = loader.getController();
            controller.init(viewModelFactory.getActivitiesViewModel(), this);
            clientActivities = new Scene(root);
        }

        mainStage.setTitle("Activities Main Window");
        mainStage.setScene(clientActivities);
    }
}

