package main.server.databaseaccess.bmi;

import main.shared.BMIData;

public interface BmiDAOModel {
    String saveBmiData(BMIData bmiData);
}
