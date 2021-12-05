package main.server.rmiserver;

import main.shared.Password;
import main.shared.UserName;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RmiServer implements RemoteServer{

    public RmiServer(){
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            Naming.rebind("DB", this);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String LoginClient(UserName userName, Password password) throws RemoteException {
        if(userName.getUserName().equals("gabriel")&&password.getPassword().equals("gabriel")){
            return "Client Login Successfully";
        }else {
            return "Wrong Credentials";
        }
    }
}
