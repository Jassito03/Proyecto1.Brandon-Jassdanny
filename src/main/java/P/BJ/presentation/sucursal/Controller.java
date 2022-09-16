package P.BJ.presentation.sucursal;

import P.BJ.Application;
import P.BJ.logic.Empleado;
import P.BJ.logic.Service;
import P.BJ.logic.Sucursal;

import javax.swing.*;
import java.awt.*;

public class Controller {
    View view;
    Model model;

    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    JDialog dialog;
    public void show(){
        dialog = new JDialog(Application.window, "Sucursal", true);
        dialog.setSize(500,300);
        dialog.setContentPane(view.getPanel());
        Point location = Application.window.getLocation();
        dialog.setLocation( location.x+400,location.y+100);
        dialog.setVisible(true);
    }

    public void closeWindow(){ dialog.dispose(); }

    public void preAdd(){
        model.setSucursal(new Sucursal());
        model.commit();
        this.show();
    }

    public void add(Sucursal s){
        Service.instance().addSucursal(s);
        model.setSucursal(new Sucursal());
        Application.sucursalesController.search("");
        model.commit();
    }

}
