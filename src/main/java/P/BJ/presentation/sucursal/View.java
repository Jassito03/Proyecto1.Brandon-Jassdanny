package P.BJ.presentation.sucursal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {

    private JPanel panel;
    private JTextField codigoTfd;
    private JTextField referenciaTfd;
    private JTextField direccionTfd;
    private JTextField zonajeTfd;
    private JButton guardarBtn;
    private JButton eliminarBtn;

    Model model;
    Controller controller;


    public View() {
        guardarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.saveData(codigoTfd.getText(), referenciaTfd.getText(), direccionTfd.getText(), zonajeTfd.getText());
                controller.closeWindow();
            }
        });
    }

    public void setModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void update(Observable updatedModel, Object param){
        this.codigoTfd.setText(model.sucursal.getCodigo());
        this.referenciaTfd.setText(model.sucursal.getReferencia());
        this.direccionTfd.setText(model.sucursal.getDireccion());
        this.zonajeTfd.setText(Float.toString(model.sucursal.getZonaje()));
    }

}
