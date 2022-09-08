package P.BJ.presentation.sucursales;

import P.BJ.logic.Sucursal;

import javax.swing.*;

public class Controller {

    Model model;
    View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        view.setController(this);
        view.setModel(model);
    }

    public javax.swing.JPanel show(){
        return view.getPanel();
    }

    public void showSucursal(Sucursal sucursal){
        JFrame window = new JFrame("Sucursal");
        window.setSize(500,500);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setVisible(true);
        window.setContentPane(model.sucursalController.show(sucursal));
    }

}
