package main.server.model.clients;

import main.shared.TheClient;

import java.util.ArrayList;

public interface ClientModel
{
  String saveClient(TheClient theClient);
  ArrayList<TheClient> getClients();
  String removeClient(TheClient theClient);
}
