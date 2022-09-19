package P.BJ.presentation.acercaDe;

import  P.BJ.Application;


import javax.swing.*;
import java.awt.*;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }


    JDialog dialog;
    public void show(){
        dialog = new JDialog(Application.window,"Acerca De", true);
        dialog.setSize(500,500);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setContentPane(view.getPanel());
        Point location = Application.window.getLocation();
        dialog.setLocation( location.x+400,location.y+100);
        dialog.setVisible(true);
    }

    public void hide(){
        dialog.dispose();
    }




}
