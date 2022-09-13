package P.BJ.presentation.sucursal;

import P.BJ.logic.Sucursal;

import java.util.Observer;

public class Model extends java.util.Observable{
    Sucursal sucursal;

    public Model() {
        sucursal = new Sucursal();
    }

    public void setSucursal(Sucursal sucursal){
        this.sucursal = sucursal;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        commit();
    }

    public void commit(){
        setChanged();
        notifyObservers(null);
    }
}
