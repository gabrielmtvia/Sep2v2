package main.client.networking.clients;

import main.shared.TheClient;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface ClientsClientModel
{
  String saveClient(TheClient theClient);
  ArrayList<TheClient> getClients();
  String removeClient(TheClient theClient);
  void addListener(String eventName, PropertyChangeListener listener);
}
