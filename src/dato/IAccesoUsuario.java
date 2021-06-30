package dato;

import Exepciones.ExcepcionAcessoDatos;
import dominio.Usuario;
import dominio.Vehiculo;

import java.util.List;

public interface IAccesoUsuario {
    void agregarUsuario(Usuario usuario) throws ExcepcionAcessoDatos;

    List<Usuario> leerUsuarios() throws ExcepcionAcessoDatos;

    Usuario mostrarUsuario(String buscar) throws ExcepcionAcessoDatos;



}
