package P.BJ.presentation.sucursal;

import P.BJ.Application;
import P.BJ.logic.Service;
import P.BJ.logic.Sucursal;

import javax.swing.*;
import java.awt.*;

public class Controller {
    View view;
    Model model;

    public Controller(Model model, View view) {
        model.setSucursal(new Sucursal());
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    JDialog dialog;
    public void show(){
        dialog = new JDialog(Application.window, "Sucursal", true);
        dialog.setSize(500,300);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setContentPane(view.getPanel());
        Point location = Application.window.getLocation();
        dialog.setLocation( location.x+400,location.y+100);
        dialog.setVisible(true);
    }

    public void closeWindow(){ dialog.dispose(); }

    public void preAdd(){
        model.setModo(Application.MODO_AGREGAR);
        model.setSucursal(new Sucursal());
        model.commit();
        this.show();
    }



    public void add(Sucursal s) throws Exception {
        Service.instance().addSucursal(s);
        model.setSucursal(new Sucursal());
        Application.sucursalesController.search("");
        model.commit();
    }

    public void guardar(Sucursal e) throws Exception {
        switch (model.getModo()) {
            case Application.MODO_AGREGAR:
                Service.instance().addSucursal(e);
                model.setSucursal(new Sucursal());
                break;
            case Application.MODO_EDITAR:
                Service.instance().sucursalUpdate(e);
                model.setSucursal(e);
                break;
        }
        Application.sucursalesController.buscar("");
        model.commit();
    }

    public void editar(Sucursal e){
        model.setModo(Application.MODO_EDITAR);
        model.setSucursal(e);
        model.commit();
        this.show();
    }

    public void show1(){
        Application.window.setContentPane(view.getPanel());
        Application.window.revalidate();
    }
    public void hide1(){
        Application.mainController.show();
    }


}
