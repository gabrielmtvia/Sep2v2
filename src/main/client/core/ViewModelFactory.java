package main.client.core;

import main.client.view.client.activities.ActivitiesViewModel;
import main.client.view.client.bmi.CalculateBmiViewModel;
import main.client.view.client.login.ClientLoginViewModel;
import main.client.view.client.personaltrainer.bookings.ClientPersonalTrainerBookingViewModel;
import main.client.view.client.personaltrainer.list.ClientPersonalTrainerListViewModel;
import main.client.view.main.MainViewModel;
import main.client.view.owner.login.OwnerLoginViewModel;
import main.client.view.owner.managestaff.AddStaffMemberViewModel;
import main.client.view.owner.staffmemberlist.StaffMemberListViewModel;
import main.client.view.staff.activities.ManageActivitiesViewModel;
import main.client.view.staff.clients.add.AddClientViewModel;
import main.client.view.staff.login.StaffLoginViewModel;
import main.client.view.staff.personaltrainers.add.AddPersonalTrainerViewModel;
import main.client.view.staff.personaltrainers.list.PersonalTrainersListViewModel;

public class ViewModelFactory {

    private ModelFactory modelFactory;
    private MainViewModel mainViewModel;
    private ClientLoginViewModel clientLoginViewModel;
    private OwnerLoginViewModel ownerLoginViewModel;
    private StaffLoginViewModel staffLoginViewModel;
    private ManageActivitiesViewModel manageActivitiesViewModel;
    private ActivitiesViewModel activitiesViewModel;
    private CalculateBmiViewModel calculateBmiViewModel;
    private AddStaffMemberViewModel addStaffMemberViewModel;
    private StaffMemberListViewModel staffMemberListViewModel;
    private AddPersonalTrainerViewModel addPersonalTrainerViewModel;
    private PersonalTrainersListViewModel personalTrainersListViewModel;
    private AddClientViewModel addClientViewModel;

    private ClientPersonalTrainerListViewModel clientPersonalTrainerListViewModel;
    private ClientPersonalTrainerBookingViewModel clientPersonalTrainerBookingViewModel;

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
            activitiesViewModel = new ActivitiesViewModel(modelFactory.getActivitiesManager(), modelFactory.getLoginManager());
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

    public AddStaffMemberViewModel getAddStaffMemberViewModel() {
        if(addStaffMemberViewModel==null)
            addStaffMemberViewModel = new AddStaffMemberViewModel(modelFactory.getManageStaffManager());
        return addStaffMemberViewModel;
    }

    public StaffMemberListViewModel getStaffMembersListViewModel() {
        if(staffMemberListViewModel==null)
            staffMemberListViewModel = new StaffMemberListViewModel(modelFactory.getManageStaffManager()) ;
        return staffMemberListViewModel;
    }

    public AddPersonalTrainerViewModel getAddPersonalTrainerViewModel() {
        if(addPersonalTrainerViewModel==null)
            addPersonalTrainerViewModel = new AddPersonalTrainerViewModel(modelFactory.getPersonalTrainerManager());
        return addPersonalTrainerViewModel;
    }

    public PersonalTrainersListViewModel getPersonalTrainersListViewModel() {
        if(personalTrainersListViewModel==null)
            personalTrainersListViewModel = new PersonalTrainersListViewModel(modelFactory.getPersonalTrainerManager());
        return personalTrainersListViewModel;
    }

    public AddClientViewModel getAddClientViewModel()
    {
        if (addClientViewModel == null)
            addClientViewModel = new AddClientViewModel(modelFactory.getClientManager());
        return addClientViewModel;
    }

    public ClientPersonalTrainerListViewModel getClientPersonalTrainerListViewModel() {
        if(clientPersonalTrainerListViewModel == null)
            clientPersonalTrainerListViewModel = new ClientPersonalTrainerListViewModel(modelFactory.getPersonalTrainerManager(), modelFactory.getLoginManager());
        return clientPersonalTrainerListViewModel;
    }

    public ClientPersonalTrainerBookingViewModel getClientPersonalTrainerBookingViewModel() {
        if(clientPersonalTrainerBookingViewModel == null)
            clientPersonalTrainerBookingViewModel = new ClientPersonalTrainerBookingViewModel(modelFactory.getPersonalTrainerManager());
        return clientPersonalTrainerBookingViewModel;
    }
}
