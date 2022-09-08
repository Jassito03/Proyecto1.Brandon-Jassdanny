package P.BJ.presentation.sucursales;

import P.BJ.logic.Sucursal;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable {

    P.BJ.presentation.sucursal.View sucursalView;
    P.BJ.presentation.sucursal.Model sucursalModel;
    P.BJ.presentation.sucursal.Controller sucursalController;

    List<Sucursal> sucursales;

    DefaultTableModel model;

    public Model(){
        sucursales = new ArrayList<>();
        sucursalView = new P.BJ.presentation.sucursal.View();
        sucursalModel = new P.BJ.presentation.sucursal.Model();
        sucursalController = new P.BJ.presentation.sucursal.Controller(sucursalModel, sucursalView);
        model = new DefaultTableModel(null, new String[]{"Codigo", "Referencia", "Direccion", "Zonaje"});
    }

    public DefaultTableModel getModel() {
        return model;
    }

    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        commit();
    }

    public void addSucursal(Sucursal sucursal){
        sucursales.add(sucursal);
        Object[] row = new Object[]{sucursal.getCodigo(), sucursal.getReferencia(), sucursal.getDireccion(), sucursal.getZonaje()};
        model.addRow(row);
    }

    public void commit(){
        setChanged();
        notifyObservers(null);
    }

}
