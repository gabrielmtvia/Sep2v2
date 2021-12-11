package main.client.model.personaltrainer;

import main.client.networking.personaltrainer.PersonalTrainerClientModel;
import main.shared.PersonalTrainer;
import main.shared.UserName;

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
        personalTrainerClient.addListener("Personal Trainer Booked", evt -> personalTrainerBooked(evt));
        personalTrainerClient.addListener("Personal Trainer Cancelled", evt -> personalTrainerCancelled(evt));
        personalTrainerClient.addListener("Personal Trainer Already Booked", evt -> personalTrainerAlreadyBooked(evt));
        personalTrainerClient.addListener("Personal Trainer Already Cancelled", evt -> personalTrainerAlreadyCancelled(evt));
    }

    private void personalTrainerAlreadyCancelled(PropertyChangeEvent evt) {
        PersonalTrainer personalTrainer = (PersonalTrainer) evt.getNewValue();
        support.firePropertyChange("Personal Trainer Already Cancelled", null, personalTrainer);
    }

    private void personalTrainerAlreadyBooked(PropertyChangeEvent evt) {
        PersonalTrainer personalTrainer = (PersonalTrainer) evt.getNewValue();
        support.firePropertyChange("Personal Trainer Already Booked", null, personalTrainer);
    }

    private void personalTrainerBooked(PropertyChangeEvent evt) {
        PersonalTrainer personalTrainer = (PersonalTrainer) evt.getNewValue();
        support.firePropertyChange("Personal Trainer Booked", null, personalTrainer);
    }

    private void personalTrainerCancelled(PropertyChangeEvent evt) {
        PersonalTrainer personalTrainer = (PersonalTrainer) evt.getNewValue();
        support.firePropertyChange("Personal Trainer Cancelled", null, personalTrainer);
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
    public ArrayList<PersonalTrainer> getPersonalTrainers(boolean staff) {
        return personalTrainerClient.getPersonalTrainers(staff);
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

    @Override
    public String bookPersonalTrainer(PersonalTrainer personalTrainer, UserName userName) {
        return personalTrainerClient.bookPersonalTrainer(personalTrainer, userName);
    }

    @Override
    public ArrayList<PersonalTrainer> viewMyBookings(UserName userName) {
        return personalTrainerClient.viewMyBookings(userName);
    }

    @Override
    public String cancelBooking(PersonalTrainer personalTrainer, UserName userName) {
        return personalTrainerClient.cancelBooking(personalTrainer, userName);
    }
}
