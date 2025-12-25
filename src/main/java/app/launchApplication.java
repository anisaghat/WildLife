package app;

import controller.controllerLOGIN;
import model.authentication.MapAuthenticator;
import view.LOGIN;

public class launchApplication
{
    private MapAuthenticator authenticator;

    public launchApplication() {
        authenticator = new MapAuthenticator();
    }

    public void start() {
        LOGIN loginView = new LOGIN();
        AppNavigator navigator = new AppNavigator(authenticator);
        new controllerLOGIN(loginView, authenticator,navigator);
        loginView.setVisible(true);
    }
}
