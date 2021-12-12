package main.client.networking.bmi;

import main.client.networking.rmi.RemoteClient;
import main.shared.BMIData;
import main.shared.UserName;

import java.rmi.RemoteException;

public class BmiClient implements BmiClientModel
{
    private RemoteClient rmiClient;

    public BmiClient(RemoteClient rmiClient)
    {
        this.rmiClient = rmiClient;
    }

    @Override
    public String saveBmiData(BMIData bmiData)
    {
        try {
            return rmiClient.saveBmiData(bmiData);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Connection error";
    }

    @Override
    public BMIData loadBmiData(UserName userName)
    {
        try {
            return rmiClient.loadBmiData(userName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteBmiData(UserName userName)
    {
        try {
            return rmiClient.deleteBmiData(userName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Connection error";
    }
}
