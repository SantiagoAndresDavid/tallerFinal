package dato;

import dominio.Usuario;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ArrayUsuarios implements IAccesoUsuarios, Serializable {
    List<Usuario> listaUsuario = new ArrayList<>();

    @Override
    public void insertarUsuario(Usuario usuario) throws IOException {
        listaUsuario.add(usuario);
    }

    @Override
    public List<Usuario> leerUsuario() throws IOException {
        return this.listaUsuario;
    }

    @Override
    public Usuario buscarUsuario(String buscar) throws IOException {
        for (Usuario usuario : listaUsuario) {
            if (usuario.getUsuario().equals(buscar)) {
                return usuario;
            }
        }
        return null;
    }


    @Override
    public void eliminarUsuario(String buscar) throws IOException {
        for (Usuario usuario : listaUsuario) {
            if (usuario.getUsuario().equals(buscar)) {
                listaUsuario.remove(usuario);
                return;
            }
        }
    }
}


