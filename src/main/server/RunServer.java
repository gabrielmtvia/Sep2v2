package main.server;

import main.server.rmiserver.RemoteServer;
import main.server.rmiserver.RmiServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;

public class RunServer {
    public static void main(String[] args) throws RemoteException{

        startRegistry();
        RmiServer server = new RmiServer();
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

