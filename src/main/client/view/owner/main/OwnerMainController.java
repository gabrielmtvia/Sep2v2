package main.client.view.owner.main;

import main.client.core.ViewHandler;

public class OwnerMainController
{
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
    }

    public void onAddStaffMember()
    {
        viewHandler.openOwnerAddAStaffMember();
    }

    public void onStaffMembersList()
    {
        viewHandler.openOwnerStaffMembersList();
    }

    public void onBackButton()
    {
       viewHandler.openOwnerLogin();
    }
}
