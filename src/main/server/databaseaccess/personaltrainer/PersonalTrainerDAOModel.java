package main.server.databaseaccess.personaltrainer;

import main.shared.PersonalTrainer;
import java.util.ArrayList;

public interface PersonalTrainerDAOModel {
    String savePersonalTrainer(PersonalTrainer personalTrainer);
    ArrayList<PersonalTrainer> getPersonalTrainers();
    String removePersonalTrainer(PersonalTrainer personalTrainer);
}
