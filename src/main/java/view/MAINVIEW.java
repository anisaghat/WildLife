package view;

import app.AppNavigator;

import javax.swing.*;

public class MAINVIEW  extends JFrame {
    private JButton buttonAdd;
    private JButton buttonDisplayMap;
    private JTable table;
    private JPanel mainPanel;
    private JButton buttonLogout;
    private JButton buttonEndangeredAnimals;

    private final AppNavigator navigator;

    public MAINVIEW(AppNavigator navigator)
    {
        this.navigator = navigator;
        setContentPane(mainPanel);
        setTitle("WILFLIFE");
        setLocationRelativeTo(null);
        setSize(700,700);

        buttonAdd.addActionListener( e -> navigator.showAddAnimalForm());
        buttonLogout.addActionListener( e -> { dispose(); System.exit(0);});
    }

}
