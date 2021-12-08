package main.client.model.bmi;

import main.client.networking.bmi.BmiClientModel;
import main.shared.BMIData;
import main.shared.UserName;

public class BmiManager implements BmiModel {

    BmiClientModel bmiClient;

    public BmiManager(BmiClientModel bmiClient){
        this.bmiClient = bmiClient;
    }

    @Override
    public String saveBmiData(BMIData bmiData) {
        return bmiClient.saveBmiData(bmiData);
    }

    @Override
    public BMIData loadBmiData(UserName userName) {
        return bmiClient.loadBmiData(userName);
    }

    @Override
    public String deleteBmiData(UserName userName) {
        return bmiClient.deleteBmiData(userName);
    }
}
