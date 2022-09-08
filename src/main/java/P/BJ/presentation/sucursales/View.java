package P.BJ.presentation.sucursales;

import P.BJ.logic.Sucursal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {

    private JPanel panel;
    private JTextField referenciaTfd;
    private JButton buscarBtn;
    private JButton agregarBtn;
    private JButton borrarBtn;
    private JButton reporteBtn;
    private JTable sucursalesTable;

    Model model;
    Controller controller;

    public View() {
        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showSucursal(new Sucursal());
            }
        });

    }

    public JPanel getPanel() {
        return panel;
    }

    public void setModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void update(Observable updatedModel, Object param){
        sucursalesTable.setModel(model.getModel());
    }
}
