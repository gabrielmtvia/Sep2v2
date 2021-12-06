package main.server.core;

import main.server.persistence.activities.ActivitiesDAO;
import main.server.persistence.activities.ActivitiesDAOModel;
import main.server.persistence.database.DBConnectionModel;
import main.server.persistence.login.LoginDAO;
import main.server.persistence.login.LoginDAOModel;

public class DAOFactory {
    private DBConnectionModel dbConnection;

    private LoginDAOModel loginDAO;
    private ActivitiesDAOModel activitiesDAO;

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

}
