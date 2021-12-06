package main.client.core;

import main.client.view.client.login.ClientLoginViewModel;
import main.client.view.main.MainViewModel;
import main.client.view.owner.login.OwnerLoginViewModel;
import main.client.view.staff.login.StaffLoginViewModel;

public class ViewModelFactory {

    private ModelFactory modelFactory;
    private MainViewModel mainViewModel;
    private ClientLoginViewModel clientLoginViewModel;
    private OwnerLoginViewModel ownerLoginViewModel;
    private StaffLoginViewModel staffLoginViewModel;

    public ViewModelFactory(ModelFactory modelFactory){
        this.modelFactory = modelFactory;
    }

    public MainViewModel getMainViewModel(){
        if(mainViewModel==null)
            mainViewModel = new MainViewModel();
        return mainViewModel;
    }

    public ClientLoginViewModel getClientLoginViewModel(){
        if(clientLoginViewModel==null)
            clientLoginViewModel = new ClientLoginViewModel(modelFactory);
        return clientLoginViewModel;
    }


    public OwnerLoginViewModel getOwnerLoginViewModel() {
        if(ownerLoginViewModel==null)
            ownerLoginViewModel = new OwnerLoginViewModel(modelFactory);
        return ownerLoginViewModel;
    }

    public StaffLoginViewModel getStaffLoginViewModel() {
        if(staffLoginViewModel== null)
            staffLoginViewModel = new StaffLoginViewModel(modelFactory);
        return staffLoginViewModel;
    }
}
