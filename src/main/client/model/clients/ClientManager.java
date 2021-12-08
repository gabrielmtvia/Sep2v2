package main.client.model.clients;

import main.client.networking.clients.ClientsClientModel;
import main.shared.TheClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ClientManager implements ClientModel
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private ClientsClientModel clientsClient;

  public ClientManager(ClientsClientModel clientsClient)
  {
    this.clientsClient = clientsClient;
    clientsClient.addListener("Client Added", evt -> clientsClientAdded(evt));
    clientsClient.addListener("Client Removed", evt -> clientsClientRemoved(evt));
  }

  private void clientsClientRemoved(PropertyChangeEvent evt)
  {
    TheClient theClient = (TheClient) evt.getNewValue();
    support.firePropertyChange("Client Removed", null, theClient);
  }

  private void clientsClientAdded(PropertyChangeEvent evt)
  {
    TheClient theClient = (TheClient) evt.getNewValue();
    support.firePropertyChange("Client Added", null, theClient);
  }

  @Override public String saveClient(TheClient theClient)
  {
    return clientsClient.saveClient(theClient);
  }

  @Override public ArrayList<TheClient> getClients()
  {
    return clientsClient.getClients();
  }

  @Override public String removeClient(TheClient theClient)
  {
    return clientsClient.removeClient(theClient);
  }

  @Override public void addListener(String eventName, PropertyChangeListener listener)
  {
    if(eventName == null || "".equals(eventName)) {
      support.addPropertyChangeListener(listener);
    } else {
      support.addPropertyChangeListener(eventName, listener);
    }
  }
}
