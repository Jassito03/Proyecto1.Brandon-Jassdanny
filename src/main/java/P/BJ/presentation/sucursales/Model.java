package P.BJ.presentation.sucursales;

import P.BJ.logic.Sucursal;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable {

    List<Sucursal> sucursales;

    public Model(){ sucursales = new ArrayList<>(); }

    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        commit();
    }

    public void addSucursal(Sucursal sucursal){
        sucursales.add(sucursal);
    }

    public void commit(){
        setChanged();
        notifyObservers(null);
    }

}
