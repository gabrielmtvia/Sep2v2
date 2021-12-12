package main.client.view.staff.clients.main;

import main.client.core.ViewHandler;

public class ClientsMainController
{
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
  }

  public void onAddClientButton()
  {
    viewHandler.openAddClient();
  }

  public void onClientsListButton()
  {
    viewHandler.openClientsList();
  }

  public void onBackButton()
  {
    viewHandler.openStaffMain();
  }
}
