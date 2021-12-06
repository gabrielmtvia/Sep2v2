package main.server;

import main.server.core.DAOFactory;
import main.server.core.ModelFactory;
import main.server.databaseaccess.database.DBConnection;
import main.server.databaseaccess.database.DBConnectionModel;
import main.server.rmiserver.RmiServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;

public class RunServer {
    public static void main(String[] args) throws RemoteException{

        startRegistry();
        DBConnectionModel dbConnection = new DBConnection();
        DAOFactory daoFactory = new DAOFactory(dbConnection);
        ModelFactory modelFactory = new ModelFactory(daoFactory);
        RmiServer server = new RmiServer(modelFactory);
        server.start();
        System.out.println("Server Started");

    }

    private static void startRegistry() throws RemoteException {
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            System.out.println("Registry started...");
        } catch (ExportException ee) {
            System.out.println("Registry already started: " + ee.getMessage());
        }
    }
}

