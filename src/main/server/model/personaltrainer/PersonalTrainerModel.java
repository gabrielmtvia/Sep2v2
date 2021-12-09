package main.server.model.personaltrainer;

import main.shared.PersonalTrainer;
import main.shared.UserName;

import java.util.ArrayList;

public interface PersonalTrainerModel {
    String savePersonalTrainer(PersonalTrainer personalTrainer);
    ArrayList<PersonalTrainer> getPersonalTrainers();
    String removePersonalTrainer(PersonalTrainer personalTrainer);

    String bookPersonalTrainer(PersonalTrainer personalTrainer, UserName userName);
}
