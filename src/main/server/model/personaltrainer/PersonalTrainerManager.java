package main.server.model.personaltrainer;

import main.server.databaseaccess.personaltrainer.PersonalTrainerDAOModel;
import main.shared.PersonalTrainer;
import main.shared.UserName;

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
    public ArrayList<PersonalTrainer> getPersonalTrainers(boolean staff) {
        return personalTrainerDAO.getPersonalTrainers(staff);
    }

    @Override
    public String removePersonalTrainer(PersonalTrainer personalTrainer) {
        return personalTrainerDAO.removePersonalTrainer(personalTrainer);
    }

    @Override
    public String bookPersonalTrainer(PersonalTrainer personalTrainer, UserName userName) {
        return personalTrainerDAO.bookPersonalTrainer(personalTrainer, userName);
    }

    @Override
    public ArrayList<PersonalTrainer> viewMyBookings(UserName userName) {
        return personalTrainerDAO.viewMyBookings(userName);
    }

    @Override
    public String cancelBooking(PersonalTrainer personalTrainer, UserName userName) {
        return personalTrainerDAO.cancelBooking(personalTrainer, userName);
    }
}
