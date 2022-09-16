package P.BJ.data;

import P.BJ.logic.Empleado;
import P.BJ.logic.Sucursal;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Sucursal> sucursales;
    private List<Empleado> empleados;

    public Data(){
        empleados = new ArrayList<>();
        sucursales = new ArrayList<>();
    }

    public List<Sucursal> getSucursales() { return sucursales; }

    public void setSucursales(List<Sucursal> sucursales) { this.sucursales = sucursales; }

    public List<Empleado> getEmpleados() { return empleados; }

    public void setEmpleados(List<Empleado> empleados) { this.empleados = empleados; }
}
