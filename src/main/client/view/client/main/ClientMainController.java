package main.client.view.client.main;

import main.client.core.ViewHandler;

public class ClientMainController
{
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
    }

    public void onPersonalData()
    {
      viewHandler.openCalculateBmi();
    }

    public void onActivities()
    {
       viewHandler.openClientActivities();
    }

    public void onPersonalTraining()
    {
        viewHandler.openClientPersonalTrainer();
    }

    public void onButtonBack()
    {
        viewHandler.openClientLogin();
    }
}
