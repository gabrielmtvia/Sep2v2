package main.server.databaseaccess.clients;

import main.server.databaseaccess.database.DBConnectionModel;
import main.shared.PersonalTrainer;
import main.shared.TheClient;

import java.util.ArrayList;

public class ClientDAO implements ClientDAOModel
{
  DBConnectionModel dbConnection;

  public ClientDAO(DBConnectionModel dbConnection)
  {
    this.dbConnection = dbConnection;
  }

  @Override public String saveClient(TheClient theClient)
  {
    return "Client has been saved successfully";
  }

  @Override public ArrayList<TheClient> getClients()
  {
    ArrayList<TheClient> test = new ArrayList<>();
    test.add(new TheClient("FullName test", "SSN test", "Username test", "Password test"));
    return test;
  }

  @Override public String removeClient(TheClient theClient)
  {
    return "Client has been deleted successfully";
  }
}
