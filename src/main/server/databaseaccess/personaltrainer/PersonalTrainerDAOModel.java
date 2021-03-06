package main.server.databaseaccess.personaltrainer;

import main.shared.PersonalTrainer;
import main.shared.UserName;

import java.util.ArrayList;

public interface PersonalTrainerDAOModel
{
    String savePersonalTrainer(PersonalTrainer personalTrainer);
    ArrayList<PersonalTrainer> getPersonalTrainers(boolean staff);
    String removePersonalTrainer(PersonalTrainer personalTrainer);
    String bookPersonalTrainer(PersonalTrainer personalTrainer, UserName userName);
    ArrayList<PersonalTrainer> viewMyBookings(UserName userName);
    String cancelBooking(PersonalTrainer personalTrainer, UserName userName);
}
