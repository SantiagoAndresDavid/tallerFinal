package dominio;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String usuario;
    private String Contraseña;
    private String tipo;

    public Usuario() {
    }

    public Usuario(String usuario, String contraseña, String tipo) {
        this.usuario = usuario;
        Contraseña = contraseña;
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", Contraseña='" + Contraseña + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
