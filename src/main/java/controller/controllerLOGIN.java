package controller;

import app.AppNavigator;
import model.authentication.MapAuthenticator;
import view.LOGIN;

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
                view.showMessage("account was not created... please try again");
            }
        }
        else
        {
            if(model.authenticate(username,password))
            {
                navigator.showMainWindow();
            }
            else
            {
                view.showMessage("login failed... please try again");
            }
        }
    }
}
