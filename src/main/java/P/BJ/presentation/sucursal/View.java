package P.BJ.presentation.sucursal;

import P.BJ.logic.Sucursal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    private JPanel panel;
    private JTextField codigoFld;
    private JTextField referenciaFld;
    private JTextField direccionFld;
    private JTextField zonajeFld;
    private JButton guardarBtn;
    private JButton cancelarBtn;

    public View() {
        guardarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.add(new Sucursal(codigoFld.getText(), referenciaFld.getText(), direccionFld.getText(), new Float(zonajeFld.getText()), null));
                controller.closeWindow();
            }
        });
        cancelarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.closeWindow();
            }
        });
    }

    public JPanel getPanel() { return panel; }

    Controller controller;
    Model model;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(Observable updatedModel, Object param){
        this.codigoFld.setText(model.sucursal.getCodigo());
        this.referenciaFld.setText(model.sucursal.getReferencia());
        this.direccionFld.setText(model.sucursal.getDireccion());
        this.zonajeFld.setText(Float.toString(model.sucursal.getZonaje()));
    }
}