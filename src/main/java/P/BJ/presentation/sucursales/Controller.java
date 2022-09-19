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
        model.setSucursales(Service.instance().searchSucursales(""));
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
    public void add(Sucursal s) throws Exception {
        Service.instance().addSucursal(s);
        this.search("");
    }

    public void editar(int row){
        String codigo = model.getSucursales().get(row).getCodigo();
        Sucursal e = null;
        try {
            e = Service.instance().sucursalGet(codigo);
            Application.sucursalController.editar(e);
        } catch (Exception ex) {}
    }

    public void borrar(int row){
        String codigo = model.getSucursales().get(row).getCodigo();
        Sucursal e=null;
        try {
            e= Service.instance().sucursalGet(codigo);
            Service.instance().sucursalDelete(e);
            this.buscar("");
        } catch (Exception ex) {}
    }
    public void buscar(String filtro){
        List<Sucursal> rows = Service.instance().searchSucursales(filtro);
        model.setSucursales(rows);
        model.commit();
    }

}
