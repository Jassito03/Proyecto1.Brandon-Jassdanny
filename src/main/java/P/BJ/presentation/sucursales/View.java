package P.BJ.presentation.sucursales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    private JPanel panel;
    private JTable sucursalesTable;
    private JTextField referenciaFld;
    private JButton buscarBtn;
    private JButton agregarBtn;
    private JButton borrarBtn;
    private JButton reporteBtn;

    public View() {
        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.preAdd();
            }
        });
        buscarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.search(referenciaFld.getText());
            }
        });
        sucursalesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = sucursalesTable.getSelectedRow();
                    controller.editar(row);
                }
            }
        });
        borrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = sucursalesTable.getSelectedRow();
                controller.borrar(row);
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
        int[] cols = {TableModel.CODIGO, TableModel.REFERENCIA, TableModel.DIRECCION, TableModel.ZONAJE};
        sucursalesTable.setModel(new TableModel(cols, model.getSucursales()));
        sucursalesTable.setRowHeight(30);
        this.panel.revalidate();
    }
}
