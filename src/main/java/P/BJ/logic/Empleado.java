package P.BJ.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Empleado {
    private String cedula;
    private String nombre;
    private int telefono;
    private float salarioBase;
    private Sucursal sucursal;

    public Empleado(String cedula, String nombre, int telefono, float salarioBase, Sucursal sucursal) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.salarioBase = salarioBase;
        this.sucursal = sucursal;
    }

    public Empleado(){ this("", "", 0, 0, null); }

    public String getCedula() { return cedula; }

    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getTelefono() { return telefono; }

    public void setTelefono(int telefono) { this.telefono = telefono; }

    public float getSalarioBase() { return salarioBase; }

    public void setSalarioBase(float salarioBase) { this.salarioBase = salarioBase; }

    public Sucursal getSucursal() { return sucursal; }

    public void setSucursal(Sucursal sucursal) { this.sucursal = sucursal; }
}
