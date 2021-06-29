package negocio;

import dato.GestionUsuario;
import dato.IAccesoUsuarios;
import dominio.Usuario;

import java.io.IOException;
import java.util.List;

public class RegistroUsuarios {
    private IAccesoUsuarios datos;

    public RegistroUsuarios() {
        this.datos = new GestionUsuario();
    }

    public void insertar(Usuario usuario) throws IOException {

        datos.insertarUsuario(usuario);
    }

    public List<Usuario> leer() {
        try {
            return datos.leerUsuario();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Usuario buscarPor(String buscar) {
        try {
            return datos.buscarUsuario(buscar);
        } catch (IOException e) {
            e.printStackTrace();
        }
      return null;
    }


    public void eliminar(String buscar) {
        try {
            datos.eliminarUsuario(buscar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
