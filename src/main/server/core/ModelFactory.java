package main.server.core;

import main.server.model.activities.ActivitiesManager;
import main.server.model.activities.ActivitiesModel;
import main.server.model.bmi.BmiManager;
import main.server.model.bmi.BmiModel;
import main.server.model.clients.ClientManager;
import main.server.model.clients.ClientModel;
import main.server.model.login.LoginManager;
import main.server.model.login.LoginModel;
import main.server.model.managestaff.ManageStaffManager;
import main.server.model.managestaff.ManageStaffModel;
import main.server.model.personaltrainer.PersonalTrainerManager;
import main.server.model.personaltrainer.PersonalTrainerModel;

public class ModelFactory
{
    private DAOFactory daoFactory;
    private LoginModel loginManager;
    private ActivitiesModel activitiesManager;
    private BmiModel bmiManager;
    private ManageStaffModel manageStaffManager;
    private PersonalTrainerModel personalTrainerManager;
    private ClientModel clientManager;

    public ModelFactory(DAOFactory daoFactory)
    {
        this.daoFactory = daoFactory;
    }

    public LoginModel getLoginManager()
    {
        if(loginManager == null)
            loginManager = new LoginManager(daoFactory.getLoginDAO());
        return loginManager;
    }

    public ActivitiesModel getActivitiesManager()
    {
        if(activitiesManager==null)
            activitiesManager = new ActivitiesManager(daoFactory.getActivitiesDAO());
        return activitiesManager;
    }

    public BmiModel getBmiManager()
    {
        if(bmiManager==null)
            bmiManager = new BmiManager(daoFactory.getBmiDAO());
        return bmiManager;
    }

    public ManageStaffModel getManageStaffManager()
    {
        if(manageStaffManager==null)
            manageStaffManager = new ManageStaffManager(daoFactory.getManageStaffDAO());
        return manageStaffManager;
    }

    public PersonalTrainerModel getPersonalTrainerManager()
    {
        if(personalTrainerManager==null)
            personalTrainerManager = new PersonalTrainerManager(daoFactory.getPersonalTrainerDAO());
        return personalTrainerManager;
    }

    public ClientModel getClientManager()
    {
        if (clientManager==null)
            clientManager = new ClientManager(daoFactory.getClientDAO());
        return clientManager;
    }
}
