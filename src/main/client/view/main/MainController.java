package main.client.view.main;

import main.client.core.ViewHandler;

public class MainController
{
    private ViewHandler viewHandler;
    private MainViewModel mainViewModel;

    public void init(MainViewModel mainViewModel, ViewHandler viewHandler)
    {
        this.mainViewModel = mainViewModel;
        this.viewHandler = viewHandler;
        mainViewModel.authenticate();
    }

    public void onClientButton()
    {
        viewHandler.openClientLogin();
    }

    public void onStaffButton()
    {
        viewHandler.openStaffLogin();
    }

    public void onOwnerButton()
    {
        viewHandler.openOwnerLogin();
    }
}
