package dato;

import dominio.Usuario;

import java.io.IOException;
import java.util.List;

public interface IAccesoUsuarios {
    void insertarUsuario(Usuario usuario) throws IOException;
    List<Usuario> leerUsuario()throws IOException;
    Usuario buscarUsuario(String buscar)throws IOException;
    void eliminarUsuario(String buscar)throws IOException;
}
