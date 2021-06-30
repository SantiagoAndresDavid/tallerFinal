package dominio;

import javax.swing.*;
import java.io.Serializable;

public class Vehiculo implements Serializable {
    private String tipo;
    private String nSerie;
    private String nAsientos;
    private String modelo;
    private String año;
    private String disponibilidad;
    private ImageIcon imageIcon;

    public Vehiculo() {
    }

    public Vehiculo(String tipo, String nSerie, String nAsientos, String modelo, String año, String disponibilidad, ImageIcon imageIcon) {
        this.tipo = tipo;
        this.nSerie = nSerie;
        this.nAsientos = nAsientos;
        this.modelo = modelo;
        this.año = año;
        this.disponibilidad = disponibilidad;
        this.imageIcon = imageIcon;
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


    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
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
