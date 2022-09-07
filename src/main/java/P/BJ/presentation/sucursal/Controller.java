package P.BJ.presentation.sucursal;

import P.BJ.Application;

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
    }

}
