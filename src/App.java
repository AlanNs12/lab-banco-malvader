package app;

import views.MainFrame;

public class App {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new MainFrame().setVisible(true);
            }
        });
    }
}
