package main.server.databaseaccess.bmi;

import main.server.databaseaccess.database.DBConnectionModel;
import main.shared.BMIData;

public class BmiDAO implements BmiDAOModel {

    private DBConnectionModel dbConnection;

    public BmiDAO(DBConnectionModel dbConnection){
        this.dbConnection = dbConnection;
    }

    @Override
    public String saveBmiData(BMIData bmiData) {
        return null;
    }
}
