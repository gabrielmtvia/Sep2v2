package main.server.model.personaltrainer;

import main.shared.PersonalTrainer;
import java.util.ArrayList;

public interface PersonalTrainerModel {
    String savePersonalTrainer(PersonalTrainer personalTrainer);
    ArrayList<PersonalTrainer> getPersonalTrainers();
    String removePersonalTrainer(PersonalTrainer personalTrainer);
}
