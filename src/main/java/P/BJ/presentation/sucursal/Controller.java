package P.BJ.presentation.sucursal;

import P.BJ.logic.Service;
import P.BJ.logic.Sucursal;

import javax.swing.FocusManager;
import java.awt.Window;

public class Controller {
    View view;
    Model model;

    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void add(Sucursal s){
        Service.instance().addSucursal(s);
    }

    public void show(){ P.BJ.presentation.sucursales.Controller.window.setContentPane(view.getPanel()); }

    public void closeWindow(){
        Window window = FocusManager.getCurrentManager().getActiveWindow();
        window.dispose();
    }
}
