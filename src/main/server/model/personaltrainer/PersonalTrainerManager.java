package main.server.model.personaltrainer;

import main.server.databaseaccess.personaltrainer.PersonalTrainerDAOModel;
import main.shared.PersonalTrainer;

import java.util.ArrayList;

public class PersonalTrainerManager implements PersonalTrainerModel{

    private PersonalTrainerDAOModel personalTrainerDAO;

    public PersonalTrainerManager(PersonalTrainerDAOModel personalTrainerDAO){
        this.personalTrainerDAO = personalTrainerDAO;
    }

    @Override
    public String savePersonalTrainer(PersonalTrainer personalTrainer) {
        return personalTrainerDAO.savePersonalTrainer(personalTrainer);
    }

    @Override
    public ArrayList<PersonalTrainer> getPersonalTrainers() {
        return personalTrainerDAO.getPersonalTrainers();
    }

    @Override
    public String removePersonalTrainer(PersonalTrainer personalTrainer) {
        return personalTrainerDAO.removePersonalTrainer(personalTrainer);
    }
}
