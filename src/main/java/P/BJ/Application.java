package P.BJ;

import P.BJ.logic.Sucursal;

import javax.swing.*;

public class Application {
    public static P.BJ.presentation.main.Controller mainController;
    public static P.BJ.presentation.sucursales.Controller sucursalesController;

    public static P.BJ.presentation.sucursal.Controller sucursalController;
    public static JFrame window;
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {}


        P.BJ.presentation.sucursales.Model sucursalesModel = new P.BJ.presentation.sucursales.Model();
        P.BJ.presentation.sucursales.View sucursalesView = new P.BJ.presentation.sucursales.View();
        sucursalesController = new P.BJ.presentation.sucursales.Controller(sucursalesModel, sucursalesView);

        P.BJ.presentation.sucursal.Model sucursalModel = new P.BJ.presentation.sucursal.Model();
        P.BJ.presentation.sucursal.View sucursalView = new P.BJ.presentation.sucursal.View();
        sucursalController = new P.BJ.presentation.sucursal.Controller(sucursalModel, sucursalView);

        P.BJ.presentation.main.Model mainModel = new P.BJ.presentation.main.Model();
        P.BJ.presentation.main.View mainView = new P.BJ.presentation.main.View();
        mainController = new P.BJ.presentation.main.Controller(mainModel, mainView);

        mainView.getTabbedPane().add("Sucursales", sucursalesView.getPanel());

        window = new JFrame();
        window.setSize(500,500);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("SISE: Sistema de Sucursales y Empleados");
        window.setVisible(true);
        mainController.show();
    }
}
