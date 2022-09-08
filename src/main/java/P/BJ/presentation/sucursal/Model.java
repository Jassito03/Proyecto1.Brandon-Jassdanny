package P.BJ.presentation.sucursal;

import P.BJ.logic.Sucursal;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable {

    P.BJ.logic.Sucursal sucursal;

    public Model(){
        sucursal = new Sucursal();
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
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
