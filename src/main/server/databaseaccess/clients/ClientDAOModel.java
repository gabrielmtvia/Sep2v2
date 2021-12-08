package main.server.databaseaccess.clients;

import main.shared.TheClient;

import java.util.ArrayList;

public interface ClientDAOModel
{
  String saveClient(TheClient theClient);
  ArrayList<TheClient> getClients();
  String removeClient(TheClient theClient);
}
