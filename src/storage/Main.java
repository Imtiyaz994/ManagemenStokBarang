package storage;

import storage.view.LoginPage;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            LoginPage login = new LoginPage();
            login.setSize(800, 600);
            login.setLocationRelativeTo(null);
            login.setResizable(false);
            login.setVisible(true);
        });

    }

}
