package dato;

import Exepciones.ExcepcionAcessoDatos;
import dominio.Usuario;
import dominio.Vehiculo;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUsuario implements IAccesoUsuario{
    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;

    private static class Usuarios implements Serializable {
         List<Usuario> lista = new ArrayList<>();
    }



    public ArchivoUsuario(String name) {
        this.archivo = new File(name);
    }

    public ArchivoUsuario() {
        this("Usuario.obj");
    }

    private Usuarios leer() throws ExcepcionAcessoDatos {
        Usuarios usuarios;
        ObjectInputStream ois = null;

        if (this.archivo.exists()) {
            try {
                this.aLectura = new FileInputStream(this.archivo);
                ois = new ObjectInputStream(this.aLectura);
                usuarios = (Usuarios) ois.readObject();
                return usuarios;
            } catch (IOException ioe) {
                throw new ExcepcionAcessoDatos("No se pudo leer el archivo.");
            } catch (ClassNotFoundException ex) {
                throw new ExcepcionAcessoDatos("La clase Publicaciones No existe");
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException ioException) {
                    }
                }
                if (this.aLectura != null) {
                    try {
                        this.aLectura.close();
                    } catch (IOException ioException) {
                    }
                }
            }
        }
        else{
            usuarios = new Usuarios();
            return usuarios;
        }

    }

    private void guardar(Usuarios usuarios) throws ExcepcionAcessoDatos {
        ObjectOutputStream oos = null;
        try {
            this.aEscritura = new FileOutputStream(this.archivo, false);
            oos = new ObjectOutputStream(this.aEscritura);
            oos.writeObject(usuarios);
        } catch (IOException ioe) {
            throw new ExcepcionAcessoDatos("No se pudo escribir en el archivo.");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                }
            }
            if (this.aEscritura != null) {
                try {
                    this.aEscritura.close();
                } catch (IOException ioe) {
                }
            }
        }
    }

    private Usuario getUsuario(List<Usuario> usuarios, String buscar) {
        for (Usuario p: usuarios) {
            if (p.getUsuario().equalsIgnoreCase(buscar)) {
                return p;
            }
        }
        return null;
    }


    @Override
    public void agregarUsuario(Usuario usuario) throws ExcepcionAcessoDatos {
       Usuarios usuarios = this.leer();
        usuarios.lista.add(usuario);
        this.guardar(usuarios);
    }

    @Override
    public List<Usuario> leerUsuarios() throws ExcepcionAcessoDatos {
        List<Usuario> usuarios = this.leer().lista;
        if (usuarios.isEmpty()) {
            throw new ExcepcionAcessoDatos("No hay usuario registradas");
        }
        return usuarios;
    }

    @Override
    public Usuario mostrarUsuario(String buscar) throws ExcepcionAcessoDatos {
        Usuario usuario = getUsuario(this.leerUsuarios(),buscar);
        if (usuario == null) {
            throw new ExcepcionAcessoDatos("No existe publicacion");
        }
        return usuario;
    }


}
