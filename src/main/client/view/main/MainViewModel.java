package main.client.view.main;

import main.client.model.login.LoginModel;

public class MainViewModel {

    private LoginModel loginManager;

    public MainViewModel(LoginModel loginManager) {
        this.loginManager = loginManager;
    }

    public void authenticate(){
        loginManager.authenticate();
    }
}
