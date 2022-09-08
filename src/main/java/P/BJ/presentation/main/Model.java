package P.BJ.presentation.main;

import P.BJ.presentation.sucursales.View;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable {

    P.BJ.presentation.sucursales.View sucursalesView;
    P.BJ.presentation.sucursales.Model sucursalesModel;
    P.BJ.presentation.sucursales.Controller sucursalesController;

    public Model(){
        sucursalesView = new P.BJ.presentation.sucursales.View();
        sucursalesModel = new P.BJ.presentation.sucursales.Model();
        sucursalesController = new P.BJ.presentation.sucursales.Controller(sucursalesModel, sucursalesView);
    }

    public View getSucursalesView() {
        return sucursalesView;
    }

    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        commit();
    }

    public void commit(){
        setChanged();
        notifyObservers(null);
    }

}
