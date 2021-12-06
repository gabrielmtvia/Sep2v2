package main.client.networking.personaltrainer;

import main.client.networking.rmi.RemoteClient;
import main.shared.PersonalTrainer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class PersonalTrainerClient implements PersonalTrainerClientModel{

    private RemoteClient rmiClient;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    
    public PersonalTrainerClient(RemoteClient rmiClient){
        this.rmiClient = rmiClient;

        try {
            rmiClient.addListener("Personal Trainer Added", evt -> personalTrainerAdded(evt));
            rmiClient.addListener("Personal Trainer Removed", evt -> personalTrainerRemoved(evt));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void personalTrainerRemoved(PropertyChangeEvent evt) {
        PersonalTrainer personalTrainer = (PersonalTrainer) evt.getNewValue();
        support.firePropertyChange("Personal Trainer Removed", null, personalTrainer);
    }

    private void personalTrainerAdded(PropertyChangeEvent evt) {
        PersonalTrainer personalTrainer = (PersonalTrainer) evt.getNewValue();
        support.firePropertyChange("Personal Trainer Added", null, personalTrainer);
    }

    @Override
    public String savePersonalTrainer(PersonalTrainer personalTrainer) {
        try {
            return rmiClient.savePersonalTrainer(personalTrainer);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return "Connection error";
    }

    @Override
    public ArrayList<PersonalTrainer> getPersonalTrainers() {
        try {
            return rmiClient.getPersonalTrainers();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String removePersonalTrainer(PersonalTrainer personalTrainer) {
        try {
            return rmiClient.removePersonalTrainer(personalTrainer);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return "Connection error";
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)) {
            support.addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(eventName, listener);
        }
    }
}
