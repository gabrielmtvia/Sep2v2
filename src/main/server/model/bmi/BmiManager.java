package main.server.model.bmi;

import main.server.databaseaccess.bmi.BmiDAOModel;
import main.shared.BMIData;

public class BmiManager implements BmiModel {

    private BmiDAOModel bmiDao;

    public BmiManager(BmiDAOModel bmiDao){
        this.bmiDao = bmiDao;
    }

    @Override
    public String saveBmiData(BMIData bmiData) {
        return bmiDao.saveBmiData(bmiData);
    }
}
