package P.BJ.presentation.main;

import P.BJ.Application;
import P.BJ.logic.Service;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.HierarchyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
public class View implements Observer {
    private JPanel panel;
    private JTabbedPane tabbedPane;

    Model model;
    Controller controller;

    public void setModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }

    public void setController(Controller controller) { this.controller = controller; }

    public JPanel getPanel() { return panel; }

    public JTabbedPane getTabbedPane() { return tabbedPane; }

    @Override
    public void update(Observable updatedModel, Object param) {
        tabbedPane.revalidate();
    }
}
