package main.server.core;

import main.server.databaseaccess.activities.ActivitiesDAO;
import main.server.databaseaccess.activities.ActivitiesDAOModel;
import main.server.databaseaccess.bmi.BmiDAO;
import main.server.databaseaccess.bmi.BmiDAOModel;
import main.server.databaseaccess.database.DBConnectionModel;
import main.server.databaseaccess.login.LoginDAO;
import main.server.databaseaccess.login.LoginDAOModel;

public class DAOFactory {
    private DBConnectionModel dbConnection;
    private LoginDAOModel loginDAO;
    private ActivitiesDAOModel activitiesDAO;
    private BmiDAOModel bmiDAO;

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

}
