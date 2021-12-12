package main.server.databaseaccess.bmi;

import main.shared.BMIData;
import main.shared.UserName;

public interface BmiDAOModel
{
    String saveBmiData(BMIData bmiData);
    BMIData loadBmiData(UserName userName);
    String deleteBmiData(UserName userName);
}
