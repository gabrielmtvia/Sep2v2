package main.server.core;

import main.server.databaseaccess.activities.ActivitiesDAO;
import main.server.databaseaccess.activities.ActivitiesDAOModel;
import main.server.databaseaccess.bmi.BmiDAO;
import main.server.databaseaccess.bmi.BmiDAOModel;
import main.server.databaseaccess.clients.ClientDAO;
import main.server.databaseaccess.clients.ClientDAOModel;
import main.server.databaseaccess.database.DBConnectionModel;
import main.server.databaseaccess.login.LoginDAO;
import main.server.databaseaccess.login.LoginDAOModel;
import main.server.databaseaccess.managestaff.ManageStaffDAO;
import main.server.databaseaccess.managestaff.ManageStaffDAOModel;
import main.server.databaseaccess.personaltrainer.PersonalTrainerDAO;
import main.server.databaseaccess.personaltrainer.PersonalTrainerDAOModel;

public class DAOFactory {
    private DBConnectionModel dbConnection;
    private LoginDAOModel loginDAO;
    private ActivitiesDAOModel activitiesDAO;
    private BmiDAOModel bmiDAO;
    private ManageStaffDAOModel manageStaffDAO;
    private PersonalTrainerDAOModel personalTrainerDAO;
    private ClientDAOModel clientDAO;

    public DAOFactory(DBConnectionModel dbConnection){
        this.dbConnection = dbConnection;
    }

    public LoginDAOModel getLoginDAO(){
        if(loginDAO == null)
            loginDAO = new LoginDAO(dbConnection);
        return loginDAO;
    }

    public ActivitiesDAOModel getActivitiesDAO(){
        if(activitiesDAO==null)
            activitiesDAO = new ActivitiesDAO(dbConnection);
        return activitiesDAO;
    }

    public BmiDAOModel getBmiDAO(){
        if(bmiDAO==null)
            bmiDAO = new BmiDAO(dbConnection);
        return bmiDAO;
    }

    public ManageStaffDAOModel getManageStaffDAO(){
        if(manageStaffDAO==null)
            manageStaffDAO = new ManageStaffDAO(dbConnection);
        return manageStaffDAO;
    }

    public PersonalTrainerDAOModel getPersonalTrainerDAO() {
        if(personalTrainerDAO==null)
            personalTrainerDAO = new PersonalTrainerDAO(dbConnection);
        return personalTrainerDAO;
    }

    public ClientDAOModel getClientDAO()
    {
        if (clientDAO==null)
            clientDAO = new ClientDAO(dbConnection);
        return clientDAO;
    }
}
