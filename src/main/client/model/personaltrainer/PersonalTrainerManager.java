package main.client.model.personaltrainer;

import main.client.networking.personaltrainer.PersonalTrainerClientModel;
import main.shared.PersonalTrainer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PersonalTrainerManager implements PersonalTrainerModel{

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private PersonalTrainerClientModel personalTrainerClient;

    public PersonalTrainerManager(PersonalTrainerClientModel personalTrainerClient){
        this.personalTrainerClient = personalTrainerClient;

        personalTrainerClient.addListener("Personal Trainer Added", evt -> personalTrainerAdded(evt));
        personalTrainerClient.addListener("Personal Trainer Removed", evt -> personalTrainerRemoved(evt));    
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
        return personalTrainerClient.savePersonalTrainer(personalTrainer);
    }

    @Override
    public ArrayList<PersonalTrainer> getPersonalTrainers() {
        return personalTrainerClient.getPersonalTrainers();
    }

    @Override
    public String removePersonalTrainer(PersonalTrainer personalTrainer) {
        return personalTrainerClient.removePersonalTrainer(personalTrainer);
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
