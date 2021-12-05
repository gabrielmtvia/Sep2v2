package main.client.networking.login;

import main.shared.Password;
import main.shared.UserName;


public interface LoginClientModel {
    String LoginClient(UserName userName, Password password);
}
