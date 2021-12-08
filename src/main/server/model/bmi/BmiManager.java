package main.server.model.bmi;

import main.server.databaseaccess.bmi.BmiDAOModel;
import main.shared.BMIData;
import main.shared.UserName;

public class BmiManager implements BmiModel {

    private BmiDAOModel bmiDao;

    public BmiManager(BmiDAOModel bmiDao){
        this.bmiDao = bmiDao;
    }

    @Override
    public String saveBmiData(BMIData bmiData) {
        return bmiDao.saveBmiData(bmiData);
    }

    @Override
    public BMIData loadBmiData(UserName userName) {
        return bmiDao.loadBmiData(userName);
    }

    @Override
    public String deleteBmiData(UserName userName) {
        return bmiDao.deleteBmiData(userName);
    }
}
