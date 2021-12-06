package main.client.networking.bmi;

import main.client.networking.rmi.RemoteClient;
import main.shared.BMIData;

import java.rmi.RemoteException;

public class BmiClient implements BmiClientModel {

    private RemoteClient rmiClient;

    public BmiClient(RemoteClient rmiClient){
        this.rmiClient = rmiClient;
    }

    @Override
    public String saveBmiData(BMIData bmiData) {
        try {
            rmiClient.saveBmiData(bmiData);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Connection error";
    }
}
