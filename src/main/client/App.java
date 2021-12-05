package main.client;

import javafx.application.Application;
import javafx.stage.Stage;
import main.client.core.ClientFactory;
import main.client.core.ModelFactory;
import main.client.core.ViewHandler;
import main.client.core.ViewModelFactory;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory clientFactory = new ClientFactory();
        ModelFactory mf = new ModelFactory(clientFactory);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(stage, vmf);
        vh.start();
    }
}
