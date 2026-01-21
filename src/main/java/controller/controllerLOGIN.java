package controller;

import app.AppNavigator;
import model.authentication.MapAuthenticator;
import view.LOGIN;

import java.util.Properties;

public class controllerLOGIN
{
    private LOGIN view ;
    private MapAuthenticator model;
    private AppNavigator navigator;
    public controllerLOGIN(LOGIN view, MapAuthenticator model, AppNavigator navigator)
    {
        this.view = view;
        this.model = model;
        this.navigator = navigator;

        view.addLoginListener(e -> handleLoginAttempt());
    }

    public void handleLoginAttempt()
    {
        boolean isNewChecked = view.getNew();
        String username = view.getUsername();
        String password = view.getPassword();

        if(isNewChecked)
        {
            boolean registred = model.register(username,password);

            if(registred)
            {
                view.showMessage("account created successfully!");
                view.dispose();
                navigator.showMainWindow();
            }
            else {
                view.showMessage("username already exists");
            }
        }
        else
        {
            if(!model.isLoginExists(username))
            {
                view.showMessage("username does not exist. plz check the new user box");
                return;
            }

            if(model.authenticate(username,password))
            {
                navigator.showMainWindow();
                view.dispose();
            }
            else
            {
                view.showMessage("password is incorrect");
            }
        }
    }
}
