package main.client.core;

import main.client.model.activities.ActivitiesManager;
import main.client.model.activities.ActivitiesModel;
import main.client.model.clients.ClientManager;
import main.client.model.clients.ClientModel;
import main.client.model.login.LoginManager;
import main.client.model.login.LoginModel;
import main.client.model.bmi.BmiManager;
import main.client.model.bmi.BmiModel;
import main.client.model.managestaff.ManageStaffManager;
import main.client.model.managestaff.ManageStaffModel;
import main.client.model.personaltrainer.PersonalTrainerManager;
import main.client.model.personaltrainer.PersonalTrainerModel;

public class ModelFactory
{
    private ClientFactory clientFactory;
    private LoginModel loginManager;
    private ActivitiesModel activitiesManager;
    private BmiModel bmiManager;
    private ManageStaffModel manageStaffManager;
    private PersonalTrainerModel personalTrainerManager;
    private ClientModel clientManager;

    public ModelFactory(ClientFactory clientFactory)
    {
        this.clientFactory = clientFactory;
    }

    public LoginModel getLoginManager()
    {
        if(loginManager==null)
            loginManager = new LoginManager(clientFactory.getLoginClient());
        return loginManager;
    }

    public ActivitiesModel getActivitiesManager()
    {
        if(activitiesManager==null)
            activitiesManager = new ActivitiesManager(clientFactory.getActivitiesClient());
        return activitiesManager;
    }

    public BmiModel getBmiManager()
    {
        if(bmiManager==null)
            bmiManager = new BmiManager(clientFactory.getBmiClient());
        return bmiManager;
    }

    public ManageStaffModel getManageStaffManager()
    {
        if(manageStaffManager==null)
            manageStaffManager = new ManageStaffManager(clientFactory.getManageStaffClient());
        return manageStaffManager;
    }

    public PersonalTrainerModel getPersonalTrainerManager()
    {
        if(personalTrainerManager==null)
            personalTrainerManager = new PersonalTrainerManager(clientFactory.getPersonalTrainerClient());
        return personalTrainerManager;
    }

    public ClientModel getClientManager()
    {
        if (clientManager==null)
            clientManager = new ClientManager(clientFactory.getClientsClient());
        return clientManager;
    }
}
