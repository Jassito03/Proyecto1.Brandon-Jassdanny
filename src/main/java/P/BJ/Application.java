package P.BJ;

import javax.swing.*;

public class Application {
    public static P.BJ.presentation.main.Controller controller;
    public static JFrame window;
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {}

        P.BJ.presentation.main.Model mainModel = new P.BJ.presentation.main.Model();
        P.BJ.presentation.main.View mainView = new P.BJ.presentation.main.View();
        controller = new P.BJ.presentation.main.Controller(mainModel, mainView);

        window = new JFrame();
        window.setSize(500,500);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("SISE: Sistema de Sucursales y Empleados");
        window.setVisible(true);
        controller.show();

    }
}
