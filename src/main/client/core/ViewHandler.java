package main.client.core;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.client.view.client.activities.ActivitiesController;
import main.client.view.client.bmi.CalculateBmiController;
import main.client.view.client.login.ClientLoginController;
import main.client.view.client.main.ClientMainController;
import main.client.view.main.MainController;
import main.client.view.owner.login.OwnerLoginController;
import main.client.view.owner.main.OwnerMainController;
import main.client.view.owner.managestaff.AddStaffMemberController;
import main.client.view.owner.staffmemberlist.StaffMemberListController;
import main.client.view.staff.activities.ManageActivitiesController;
import main.client.view.staff.clients.add.AddClientController;
import main.client.view.staff.clients.main.ClientsMainController;
import main.client.view.staff.login.StaffLoginController;
import main.client.view.staff.main.StaffMainController;
import main.client.view.staff.personaltrainers.add.AddPersonalTrainerController;
import main.client.view.staff.personaltrainers.list.PersonalTrainersListController;
import main.client.view.staff.personaltrainers.main.PersonalTrainersMainController;


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
    private Scene manageActivities;
    private Scene calculateBmi;
    private Scene addStaffMember;
    private Scene ownerStaffMembersList;
    private Scene personalTrainersMain;
    private Scene addPersonalTrainer;
    private Scene personalTrainersList;
    private Scene addClient;
    private Scene clientMain;

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

    public void openManageActivities() {
        FXMLLoader loader = new FXMLLoader();

        if(manageActivities == null)
        {
            Parent root = getRootByPath("../view/staff/activities/manageactivities.fxml", loader);
            ManageActivitiesController controller = loader.getController();
            controller.init(viewModelFactory.getManageActivitiesViewModel(), this);
            manageActivities = new Scene(root);
        }

        mainStage.setTitle("Staff Manage Activities");
        mainStage.setScene(manageActivities);
    }

    public void openCalculateBmi() {
        FXMLLoader loader = new FXMLLoader();

        if(calculateBmi == null)
        {
            Parent root = getRootByPath("../view/client/bmi/calculatebmi.fxml", loader);
            CalculateBmiController controller = loader.getController();
            controller.init(viewModelFactory.getCalculateBmiViewModel(), this);
            calculateBmi = new Scene(root);
        }

        mainStage.setTitle("Manage personal info");
        mainStage.setScene(calculateBmi);
    }

    public void openOwnerAddAStaffMember() {
        FXMLLoader loader = new FXMLLoader();

        if(addStaffMember == null)
        {
            Parent root = getRootByPath("../view/owner/managestaff/addstaffmember.fxml", loader);
            AddStaffMemberController controller = loader.getController();
            controller.init(viewModelFactory.getAddStaffMemberViewModel(), this);
            addStaffMember = new Scene(root);
        }

        mainStage.setTitle("Add Staff Member");
        mainStage.setScene(addStaffMember);
    }

    public void openOwnerStaffMembersList() {
        FXMLLoader loader = new FXMLLoader();

        if(ownerStaffMembersList == null)
        {
            Parent root = getRootByPath("../view/owner/staffmemberlist/staffmemberlist.fxml", loader);
            StaffMemberListController controller = loader.getController();
            controller.init(viewModelFactory.getStaffMembersListViewModel(), this);
            ownerStaffMembersList = new Scene(root);
        }

        mainStage.setTitle("Staff-Members List");
        mainStage.setScene(ownerStaffMembersList);
    }

    public void openPersonalTrainers() {
        FXMLLoader loader = new FXMLLoader();

        if(personalTrainersMain == null)
        {
            Parent root = getRootByPath("../view/staff/personaltrainers/main/personaltrainersmain.fxml", loader);
            PersonalTrainersMainController controller = loader.getController();
            controller.init(this);
            personalTrainersMain = new Scene(root);
        }

        mainStage.setTitle("Personal Trainers Main");
        mainStage.setScene(personalTrainersMain);
    }

    public void openAddPersonalTrainer() {
        FXMLLoader loader = new FXMLLoader();

        if(addPersonalTrainer == null)
        {
            Parent root = getRootByPath("../view/staff/personaltrainers/add/addpersonaltrainer.fxml", loader);
            AddPersonalTrainerController controller = loader.getController();
            controller.init(viewModelFactory.getAddPersonalTrainerViewModel(),this);
            addPersonalTrainer = new Scene(root);
        }

        mainStage.setTitle("Add a personal trainer");
        mainStage.setScene(addPersonalTrainer);
    }

    public void openPersonalTrainersList() {
        FXMLLoader loader = new FXMLLoader();

        if(personalTrainersList == null)
        {
            Parent root = getRootByPath("../view/staff/personaltrainers/list/personaltrainerslist.fxml", loader);
            PersonalTrainersListController controller = loader.getController();
            controller.init(viewModelFactory.getPersonalTrainersListViewModel(),this);
            personalTrainersList = new Scene(root);
        }

        mainStage.setTitle("Personal trainers list");
        mainStage.setScene(personalTrainersList);
    }

    public void openAddClient()
    {
        FXMLLoader loader = new FXMLLoader();

        if (addClient == null)
        {
            Parent root = getRootByPath("../view/staff/clients/add/addClient.fxml", loader);
            AddClientController controller = loader.getController();
            controller.init(viewModelFactory.getAddClientViewModel(), this);
            addClient = new Scene(root);
        }

        mainStage.setTitle("Add a client");
        mainStage.setScene(addClient);
    }

    public void openClientsMain()
    {
        FXMLLoader loader = new FXMLLoader();

        if (clientMain == null)
        {
            Parent root = getRootByPath("../view/staff/clients/main/clientsMain.fxml", loader);
            ClientsMainController controller = loader.getController();
            controller.init(this);
            clientMain = new Scene(root);
        }

        mainStage.setTitle("Client Main");
        mainStage.setScene(clientMain);
    }
}

