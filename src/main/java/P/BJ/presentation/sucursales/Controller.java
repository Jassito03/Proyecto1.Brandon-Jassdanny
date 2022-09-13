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

    P.BJ.presentation.sucursal.Model sucursalModel = new P.BJ.presentation.sucursal.Model();
    P.BJ.presentation.sucursal.View sucursalView = new P.BJ.presentation.sucursal.View();
    P.BJ.presentation.sucursal.Controller sucursalController = new P.BJ.presentation.sucursal.Controller(sucursalModel, sucursalView);

    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void show(){
        Application.window.setContentPane(view.getPanel());
    }

    public void showSucursal(){
        window = new JFrame("Sucursal");
        window.setSize(500,500);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setVisible(true);
        sucursalController.show();
    }

    public void search(String filtro){
        List<Sucursal> rows = Service.instance().searchSucursales(filtro);
        model.setSucursales(rows);
        model.commit();
    }

    public void add(Sucursal s){
        Service.instance().addSucursal(s);
        this.search("");
    }
}
