package app;

import controller.controllerLOGIN;
import model.authentication.MapAuthenticator;
import view.LOGIN;
import view.MAINVIEW;

public class AppNavigator {

    private final MapAuthenticator authenticator;
    public AppNavigator(MapAuthenticator authenticator) {
        this.authenticator = authenticator;
    }

    public void showLogin() {
        LOGIN view = new LOGIN();
        new controllerLOGIN(view, authenticator, this);
        view.setVisible(true);
    }

    public void showMainWindow() {
        MAINVIEW main = new MAINVIEW();
        main.setVisible(true);
    }

}
