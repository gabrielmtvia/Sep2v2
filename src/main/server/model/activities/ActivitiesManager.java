package main.server.model.activities;
import main.server.databaseaccess.activities.ActivitiesDAOModel;
import main.shared.Activity;
import java.util.ArrayList;

public class ActivitiesManager implements ActivitiesModel {

    private ActivitiesDAOModel activitiesDAO;

    public ActivitiesManager(ActivitiesDAOModel activitiesDAO){
        this.activitiesDAO = activitiesDAO;
    }

    @Override
    public ArrayList<Activity> requestActivities() {
        return activitiesDAO.requestActivities();
    }

    @Override
    public String deleteActivity(Activity activity) {
        return activitiesDAO.deleteActivity(activity);
    }

    @Override
    public String saveActivity(Activity activity) {
        return activitiesDAO.saveActivity(activity);
    }

}
