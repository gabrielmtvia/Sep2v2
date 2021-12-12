package main.server.model.bmi;

import main.shared.BMIData;
import main.shared.UserName;

public interface BmiModel
{
    String saveBmiData(BMIData bmiData);
    BMIData loadBmiData(UserName userName);
    String deleteBmiData(UserName userName);
}
