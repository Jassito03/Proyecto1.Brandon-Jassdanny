package P.BJ.presentation.sucursal;

import P.BJ.logic.Sucursal;
import P.BJ.Application;


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
                if (validate()) {
                    Sucursal n = take();
                    try {
                    controller.guardar(n);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
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
        Sucursal suc = model.getSucursal();
        this.codigoFld.setEnabled(model.getModo() == Application.MODO_AGREGAR);
        this.codigoFld.setText(suc.getCodigo());
        this.referenciaFld.setText(suc.getReferencia());
        this.direccionFld.setText(suc.getDireccion());
        this.zonajeFld.setText(Float.toString(model.sucursal.getZonaje()));
        this.panel.validate();

    }

    public Sucursal take(){
        Sucursal s = new Sucursal();
        s.setCodigo(codigoFld.getText());
        s.setReferencia(referenciaFld.getText());
        s.setDireccion(direccionFld.getText());
        s.setZonaje(new Float(zonajeFld.getText()));
        return s;
    }

    private boolean validate() {
        boolean valid = true;
        if (codigoFld.getText().isEmpty()) {
            valid = false;
            codigoFld.setBorder(Application.BORDER_ERROR);
            codigoFld.setToolTipText("Id requerido");
        } else {
            codigoFld.setBorder(null);
            codigoFld.setToolTipText(null);
        }

        if (referenciaFld.getText().length() == 0) {
            valid = false;
            referenciaFld.setBorder(Application.BORDER_ERROR);
            referenciaFld.setToolTipText("Nombre requerido");
        } else {
            referenciaFld.setBorder(null);
            referenciaFld.setToolTipText(null);
        }

        if (direccionFld.getText().length() == 0) {
            valid = false;
            direccionFld.setBorder(Application.BORDER_ERROR);
            direccionFld.setToolTipText("Direccion requerida");
        } else {
            direccionFld.setBorder(null);
            direccionFld.setToolTipText(null);
        }
        if (zonajeFld.getText().equals(0.0)) {
            valid = false;
            zonajeFld.setBorder(Application.BORDER_ERROR);
            zonajeFld.setToolTipText("Zonaje requerido");
        } else {
            zonajeFld.setBorder(null);
            zonajeFld.setToolTipText(null);
        }
        return valid;
    }
}