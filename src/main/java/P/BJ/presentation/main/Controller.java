package P.BJ.presentation.main;

import P.BJ.Application;

import P.BJ.logic.Service;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Controller {

    Model model;
    View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        view.setController(this);
        view.setModel(model);
    }
    public void show(){
        Application.window.setContentPane(view.getPanel());
        Application.window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Service.instance().store();
            }
        });
    }
}
