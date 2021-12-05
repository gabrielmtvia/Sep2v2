package main.client.core;

import main.client.view.client.login.ClientLoginViewModel;
import main.client.view.main.MainViewModel;

public class ViewModelFactory {

    private ModelFactory modelFactory;
    private MainViewModel mainViewModel;
    private ClientLoginViewModel clientLoginViewModel;

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


}
