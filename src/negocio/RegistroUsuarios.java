package negocio;


import Exepciones.ExcepcionAcessoDatos;
import dato.ArchivoUsuario;
import dato.IAccesoUsuario;
import dominio.Usuario;

import java.util.List;

public class RegistroUsuarios {
    private IAccesoUsuario dato;

    public RegistroUsuarios() {
        this.dato = new ArchivoUsuario();
    }

    public void insertar(Usuario usuario) throws ExcepcionAcessoDatos {
            dato.agregarUsuario(usuario);
    }

    public List<Usuario> leer() {
        try {
            return dato.leerUsuarios();
        } catch (ExcepcionAcessoDatos excepcionAcessoDatos) {
            excepcionAcessoDatos.printStackTrace();
        }
        return null;
    }

    public Usuario buscarPor(String buscar) {
        try {
            return dato.mostrarUsuario(buscar);
        } catch (ExcepcionAcessoDatos excepcionAcessoDatos) {
            excepcionAcessoDatos.printStackTrace();
        }
        return null;
    }

}
