package P.BJ.logic;

import P.BJ.data.Data;
import P.BJ.data.XmlPersister;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private Data data;
    private static Service theInstance;

    private Service(){
        //data = new Data();
        try{
            data= XmlPersister.instance().load();
        }
        catch(Exception e){
            data =  new Data();
        }
    }

    public List<Empleado> empleadosSearch(String filtro){
        return data.getEmpleados().stream()
                .filter(e->e.getNombre().contains(filtro))
                .sorted(Comparator.comparing(Empleado::getCedula))
                .collect(Collectors.toList());
    }

    public Empleado empleadoGet(String cedula) throws Exception{
        Empleado result = data.getEmpleados().stream().filter(e->e.getCedula().equals(cedula)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Empleado no existe");
    }

    public void empleadoAdd(Empleado empleado) throws Exception{
        Empleado result = data.getEmpleados().stream().filter(e->e.getCedula().equals(empleado.getCedula())).findFirst().orElse(null);
        if (result==null) data.getEmpleados().add(empleado);
        else throw new Exception("Empleado ya existe");
    }

    public void empleadoDelete(Empleado empleado) throws Exception{
        Empleado result = data.getEmpleados().stream().filter(e->e.getCedula().equals(empleado.getCedula())).findFirst().orElse(null);
        if (result!=null) data.getEmpleados().remove(empleado);
        else throw new Exception("Empleado no existe");
    }

    public void empleadoUpdate(Empleado empleado) throws Exception{
        Empleado result;
        try{
            result = this.empleadoGet(empleado.getCedula());
            data.getEmpleados().remove(result);
            data.getEmpleados().add(empleado);
        }catch (Exception e) {
            throw new Exception("Empleado no existe");
        }
    }

    public void store(){
        try {
            XmlPersister.instance().store(data);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Service instance(){
        if(theInstance == null){
            theInstance = new Service();
        }
        return theInstance;
    }



    public List<Sucursal> searchSucursales(String filtro){
        return data.getSucursales().stream()
                .filter(e->e.getReferencia().contains(filtro))
                .sorted(Comparator.comparing(Sucursal::getCodigo))
                .collect(Collectors.toList());
    }
    public void addSucursal(Sucursal suc) throws Exception {
        Sucursal result = data.getSucursales().stream().filter(e->e.getCodigo().equals(suc.getCodigo())).findFirst().orElse(null);
        if (result==null) data.getSucursales().add(suc);
        else throw new Exception("Sucursal ya existe");
    }


    public Sucursal sucursalGet(String suc) throws Exception{
        Sucursal result = data.getSucursales().stream().filter(e->e.getCodigo().equals(suc)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Sucursal no existe");
    }



    public void sucursalDelete(Sucursal suc) throws Exception{
        Sucursal result = data.getSucursales().stream().filter(e->e.getCodigo().equals(suc.getCodigo())).findFirst().orElse(null);
        if (result!=null) data.getSucursales().remove(suc);
        else throw new Exception("Sucursal no existe");
    }

    public void sucursalUpdate(Sucursal suc) throws Exception{
        Sucursal result;
        try{
            result = this.sucursalGet(suc.getCodigo());
            data.getSucursales().remove(result);
            data.getSucursales().add(suc);
        }catch (Exception e) {
            throw new Exception("Sucursal no existe");
        }
    }

}
