package dominio;

import java.io.Serializable;

public class Vehiculo implements Serializable {
    private String tipo;
    private String nSerie;
    private String nAsientos;
    private String modelo;
    private String año;
    private String disponibilidad;

    public Vehiculo() {
    }

    public Vehiculo(String tipo, String nSerie, String nAsientos, String modelo, String año, String disponibilidad) {
        this.tipo = tipo;
        this.nSerie = nSerie;
        this.nAsientos = nAsientos;
        this.modelo = modelo;
        this.año = año;
        this.disponibilidad = disponibilidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getnSerie() {
        return nSerie;
    }

    public void setnSerie(String nSerie) {
        this.nSerie = nSerie;
    }

    public String getnAsientos() {
        return nAsientos;
    }

    public void setnAsientos(String nAsientos) {
        this.nAsientos = nAsientos;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getDataText(){
        return this.tipo+";"+this.nSerie+";"+this.nAsientos+";"+this.modelo+";"+this.año+";"+disponibilidad;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "tipo='" + tipo + '\'' +
                ", nSerie='" + nSerie + '\'' +
                ", nAsientos='" + nAsientos + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año='" + año + '\'' +
                '}';
    }
}
