package main.client.view.staff.main;

import main.client.core.ViewHandler;

public class StaffMainController
{
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
  }

  public void onActivitiesButtonClick()
  {
     viewHandler.openManageActivities();
  }

  public void onClientsButtonClick()
  {
    viewHandler.openClientsMain();
  }

  public void onPersonalTrainersButtonClick()
  {
    viewHandler.openPersonalTrainers();
  }

  public void onBackButtonClick()
  {
    viewHandler.openStaffLogin();
  }
}
