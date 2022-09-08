package P.BJ.presentation.sucursal;

import P.BJ.logic.Sucursal;

import javax.swing.*;
import java.awt.Window;

public class Controller {

    Model model;
    View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        view.setController(this);
        view.setModel(model);
    }

    public javax.swing.JPanel show(Sucursal sucursal){
        model.setSucursal(sucursal);
        return view.getPanel();
    }

    public void closeWindow(){
        Window window = FocusManager.getCurrentManager().getActiveWindow();
        window.dispose();
    }

    public void saveData(String codigo, String referencia, String direccion, String zonaje){
        model.setSucursal(new Sucursal(codigo, referencia, direccion, new Float(zonaje), null));
    }
}
