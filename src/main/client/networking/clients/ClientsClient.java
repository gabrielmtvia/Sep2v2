package main.client.networking.clients;

import main.client.networking.rmi.RemoteClient;
import main.shared.TheClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ClientsClient implements ClientsClientModel
{
  private RemoteClient rmiClient;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public ClientsClient(RemoteClient rmiClient)
  {
    this.rmiClient = rmiClient;

    try {
      rmiClient.addListener("Client Added", evt -> clientAdded(evt));
      rmiClient.addListener("Client Removed", evt -> clientRemoved(evt));
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  private void clientRemoved(PropertyChangeEvent evt)
  {
    TheClient theClient = (TheClient) evt.getNewValue();
    support.firePropertyChange("Client Removed", null, theClient);
  }

  private void clientAdded(PropertyChangeEvent evt)
  {
    TheClient theClient = (TheClient) evt.getNewValue();
    support.firePropertyChange("Client Added", null, theClient);
  }

  @Override public String saveClient(TheClient theClient)
  {
    try {
      return rmiClient.saveClient(theClient);
    } catch (RemoteException e) {
      e.printStackTrace();
    }

    return "Connection error";
  }

  @Override public ArrayList<TheClient> getClients()
  {
    try {
      return rmiClient.getClients();
    } catch (RemoteException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override public String removeClient(TheClient theClient)
  {
    try {
      return rmiClient.removeClient(theClient);
    } catch (RemoteException e) {
      e.printStackTrace();
    }

    return "Connection error";
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
