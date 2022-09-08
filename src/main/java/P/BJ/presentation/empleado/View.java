package P.BJ.presentation.empleado;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {

    private JPanel panel;

    Model model;
    Controller controller;


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

    }
}
