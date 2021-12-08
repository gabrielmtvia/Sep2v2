package main.client.model.bmi;

import main.client.networking.bmi.BmiClientModel;
import main.shared.BMIData;

public class BmiManager implements BmiModel {

    BmiClientModel bmiClient;

    public BmiManager(BmiClientModel bmiClient){
        this.bmiClient = bmiClient;
    }

    @Override
    public String saveBmiData(BMIData bmiData) {
        return bmiClient.saveBmiData(bmiData);
    }
}
