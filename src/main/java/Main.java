import app.launchApplication;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new launchApplication().start());
    }
}
