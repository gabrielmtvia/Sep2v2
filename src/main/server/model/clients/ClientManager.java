package main.server.model.clients;

import main.server.databaseaccess.clients.ClientDAOModel;
import main.shared.TheClient;

import java.util.ArrayList;

public class ClientManager implements ClientModel
{
  private ClientDAOModel clientDAO;

  public ClientManager(ClientDAOModel clientDAO)
  {
    this.clientDAO = clientDAO;
  }

  @Override public String saveClient(TheClient theClient)
  {
    return clientDAO.saveClient(theClient);
  }

  @Override public ArrayList<TheClient> getClients()
  {
    return clientDAO.getClients();
  }

  @Override public String removeClient(TheClient theClient)
  {
    return clientDAO.removeClient(theClient);
  }
}
