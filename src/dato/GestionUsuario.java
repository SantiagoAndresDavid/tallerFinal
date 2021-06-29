package dato;

import dominio.Usuario;

import java.io.*;
import java.util.List;

public class GestionUsuario implements IAccesoUsuarios{
    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;

    public GestionUsuario(String name) {
        this.archivo = new File(name);
    }

    public GestionUsuario() {
        this("Usuarios.obj");
    }

    private void guardar(ArrayUsuarios lista) throws IOException {
        ObjectOutputStream oos = null;
        try {
            this.aEscritura = new FileOutputStream(this.archivo, false);
            oos = new ObjectOutputStream(this.aEscritura);
            oos.writeObject(lista);
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (this.aEscritura != null) {
                this.aEscritura.close();
            }
        }
    }

    private ArrayUsuarios leer() throws IOException {
        ArrayUsuarios lista;
        ObjectInputStream ois = null;

        if (this.archivo.exists()) {
            try {
                this.aLectura = new FileInputStream(this.archivo);
                ois = new ObjectInputStream(this.aLectura);
                lista = (ArrayUsuarios) ois.readObject();
                return lista;
            } catch (IOException ioe) {
                throw ioe;
            } catch (ClassNotFoundException ex) {
                throw new IOException("La clase ArrayAccesoDatos  No existe");
            } finally {
                if (ois != null) {
                    ois.close();
                }
                if (this.aLectura != null) {
                    this.aLectura.close();
                }
            }
        }
        else{
            lista = new ArrayUsuarios();
            return lista;
        }
    }


    @Override
    public void insertarUsuario(Usuario usuario) throws IOException {
        ArrayUsuarios lista = this.leer();
        lista.insertarUsuario(usuario);
        this.guardar(lista);
    }

    @Override
    public List<Usuario> leerUsuario() throws IOException {
        ArrayUsuarios lista = this.leer();
        return lista.leerUsuario();
    }

    @Override
    public Usuario buscarUsuario(String buscar) throws IOException {
        ArrayUsuarios lista = this.leer();
        return lista.buscarUsuario(buscar);
    }

    @Override
    public void eliminarUsuario(String buscar) throws IOException {
        ArrayUsuarios lista = this.leer();
        lista.eliminarUsuario(buscar);
    }
}
