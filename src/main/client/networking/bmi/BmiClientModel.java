package main.client.networking.bmi;

import main.shared.BMIData;
import main.shared.UserName;

public interface BmiClientModel
{
    String saveBmiData(BMIData bmiData);
    BMIData loadBmiData(UserName userName);
    String deleteBmiData(UserName userName);
}
