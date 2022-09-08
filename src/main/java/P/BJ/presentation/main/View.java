package P.BJ.presentation.main;

import P.BJ.presentation.main.Controller;
import P.BJ.presentation.main.Model;
import P.BJ.presentation.acercade.View;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    private JPanel panel;
    private JTabbedPane taps;

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
