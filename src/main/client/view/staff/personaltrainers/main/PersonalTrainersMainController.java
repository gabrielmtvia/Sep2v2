package main.client.view.staff.personaltrainers.main;

import main.client.core.ViewHandler;

public class PersonalTrainersMainController
{
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
  }

  public void onAddPersonalTrainerButtonClick()
  {
    viewHandler.openAddPersonalTrainer();
  }

  public void onPersonalTrainersListButtonClick()
  {
    viewHandler.openPersonalTrainersList();
  }

  public void onBackButtonClick()
  {
    viewHandler.openStaffMain();
  }
}
