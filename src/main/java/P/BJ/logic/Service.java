package P.BJ.logic;

import P.BJ.data.Data;

import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private Data data;
    private static Service theInstance;
    private Service(){ data = new Data(); }

    public static Service instance(){
        if(theInstance == null){
            theInstance = new Service();
        }
        return theInstance;
    }

    public Data getData() { return data; }

    public List<Sucursal> searchSucursales(String filtro){
        return data.getSucursales().stream().filter(s->s.getReferencia().contains(filtro)).collect(Collectors.toList());
    }
    public void addSucursal(Sucursal suc){
        List<Sucursal> result = data.getSucursales().stream().filter(s->s.getCodigo().equals(suc.getCodigo())).collect(Collectors.toList());
        if(result.size() == 0){
            data.getSucursales().add(suc);
        }
    }
}
