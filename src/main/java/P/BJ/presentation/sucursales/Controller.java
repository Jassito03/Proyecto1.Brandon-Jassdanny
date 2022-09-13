package P.BJ.presentation.sucursales;

import P.BJ.Application;
import P.BJ.logic.Service;
import P.BJ.logic.Sucursal;

import javax.swing.*;
import java.util.List;

public class Controller {
    public static JFrame window;
    View view;
    Model model;

    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void show(){
        Application.window.setContentPane(view.getPanel());
    }

    public void search(String filtro){
        List<Sucursal> rows = Service.instance().searchSucursales(filtro);
        model.setSucursales(rows);
        model.commit();
    }
    public void preAdd(){
        Application.sucursalController.preAdd();
    }
    public void add(Sucursal s){
        Service.instance().addSucursal(s);
        this.search("");
    }
}
