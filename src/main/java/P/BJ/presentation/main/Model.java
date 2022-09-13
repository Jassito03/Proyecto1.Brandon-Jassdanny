package P.BJ.presentation.main;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable {

    public Model(){

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
