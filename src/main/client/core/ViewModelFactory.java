package main.client.core;

import main.client.view.client.activities.ActivitiesViewModel;
import main.client.view.client.bmi.CalculateBmiViewModel;
import main.client.view.client.login.ClientLoginViewModel;
import main.client.view.main.MainViewModel;
import main.client.view.owner.login.OwnerLoginViewModel;
import main.client.view.staff.activities.ManageActivitiesViewModel;
import main.client.view.staff.login.StaffLoginViewModel;

public class ViewModelFactory {

    private ModelFactory modelFactory;
    private MainViewModel mainViewModel;
    private ClientLoginViewModel clientLoginViewModel;
    private OwnerLoginViewModel ownerLoginViewModel;
    private StaffLoginViewModel staffLoginViewModel;
    private ActivitiesViewModel activitiesViewModel;
    private ManageActivitiesViewModel manageActivitiesViewModel;
    private CalculateBmiViewModel calculateBmiViewModel;

    public ViewModelFactory(ModelFactory modelFactory){
        this.modelFactory = modelFactory;
    }

    public MainViewModel getMainViewModel(){
        if(mainViewModel==null)
            mainViewModel = new MainViewModel(modelFactory.getLoginManager());
        return mainViewModel;
    }

    public ClientLoginViewModel getClientLoginViewModel(){
        if(clientLoginViewModel==null)
            clientLoginViewModel = new ClientLoginViewModel(modelFactory.getLoginManager());
        return clientLoginViewModel;
    }


    public OwnerLoginViewModel getOwnerLoginViewModel() {
        if(ownerLoginViewModel==null)
            ownerLoginViewModel = new OwnerLoginViewModel(modelFactory.getLoginManager());
        return ownerLoginViewModel;
    }

    public StaffLoginViewModel getStaffLoginViewModel() {
        if(staffLoginViewModel== null)
            staffLoginViewModel = new StaffLoginViewModel(modelFactory.getLoginManager());
        return staffLoginViewModel;
    }

    public ActivitiesViewModel getActivitiesViewModel() {
        if(activitiesViewModel==null)
            activitiesViewModel = new ActivitiesViewModel(modelFactory.getActivitiesManager());
        return activitiesViewModel;
    }

    public ManageActivitiesViewModel getManageActivitiesViewModel() {
        if(manageActivitiesViewModel==null)
            manageActivitiesViewModel = new ManageActivitiesViewModel(modelFactory.getActivitiesManager());
        return manageActivitiesViewModel;
    }

    public CalculateBmiViewModel getCalculateBmiViewModel(){
        if(calculateBmiViewModel==null)
            calculateBmiViewModel = new CalculateBmiViewModel(modelFactory.getBmiManager(), modelFactory.getLoginManager());
        return calculateBmiViewModel;
    }

}
