package P.BJ.presentation.acercaDe;



import javax.swing.*;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer{

    Controller controller;
    Model model;
    private JPanel panel;
    private JLabel imagen;


    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
