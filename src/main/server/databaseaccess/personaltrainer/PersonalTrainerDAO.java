package main.server.databaseaccess.personaltrainer;

import main.server.databaseaccess.database.DBConnectionModel;
import main.shared.PersonalTrainer;

import java.util.ArrayList;

public class PersonalTrainerDAO implements PersonalTrainerDAOModel {

    DBConnectionModel dbConnection;

    public PersonalTrainerDAO(DBConnectionModel dbConnection){
        this.dbConnection = dbConnection;
    }

    @Override
    public String savePersonalTrainer(PersonalTrainer personalTrainer) {
        return "Personal trainer has been saved successfully";
    }

    @Override
    public ArrayList<PersonalTrainer> getPersonalTrainers() {
        ArrayList<PersonalTrainer> test = new ArrayList<>();
        test.add(new PersonalTrainer("Dummy test", "Dummy number", "Dummy ssn"));
        test.add(new PersonalTrainer("Dummy", "Dummy number", "Dummy ssn"));
        test.add(new PersonalTrainer("Dummy test", "Dummy", "Dummy ssn"));
        test.add(new PersonalTrainer("Dummy test", "Dummy number", "ssn"));
        test.add(new PersonalTrainer("Dummy ", "number", "Dummy ssn"));
        return test;
    }

    @Override
    public String removePersonalTrainer(PersonalTrainer personalTrainer) {
        return "Personal trainer has been deleted successfully";
    }
}