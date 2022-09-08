package P.BJ.logic;

import java.awt.Point;

public class Sucursal {
    private String codigo;
    private String referencia;
    private String direccion;
    private float zonaje;
    private Point puntoMapa;

    public Sucursal(){
        this.codigo = "";
        this.referencia = "";
        this.direccion = "";
        this.zonaje = 0;
        this.puntoMapa = null;
    }
    public Sucursal(String codigo, String referencia, String direccion, float zonaje, Point puntoMapa) {
        this.codigo = codigo;
        this.referencia = referencia;
        this.direccion = direccion;
        this.zonaje = zonaje;
        this.puntoMapa = puntoMapa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getZonaje() {
        return zonaje;
    }

    public void setZonaje(float zonaje) {
        this.zonaje = zonaje;
    }

    public Point getPuntoMapa() {
        return puntoMapa;
    }

    public void setPuntoMapa(Point puntoMapa) {
        this.puntoMapa = puntoMapa;
    }

}
