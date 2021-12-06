package main.client.view.client.main;

import javafx.event.ActionEvent;
import main.client.core.ViewHandler;


public class ClientMainController {

  ViewHandler viewHandler;

    public void init(ViewHandler viewHandler){
        this.viewHandler = viewHandler;
    }

    public void onPersonalData(ActionEvent actionEvent) {
     // viewHandler.openCalculateBmi();
    }

    public void onActivities(ActionEvent actionEvent) {
       // viewHandler.openClientActivities();
    }

    public void onPersonalTraining(ActionEvent actionEvent) {
    }

    public void onButtonBack(ActionEvent actionEvent) {
        viewHandler.openClientLogin();
    }

}
