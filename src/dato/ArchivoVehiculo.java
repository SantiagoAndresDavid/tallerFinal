package dato;

import Exepciones.ExcepcionAcessoDatos;
import dominio.Vehiculo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoVehiculo implements IAccesoVehiculo{
    private final File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;

    private static class Vehiculos implements Serializable {
         List<Vehiculo> lista = new ArrayList<>();
    }

    public ArchivoVehiculo(String name) {
        this.archivo = new File(name);
    }

    public ArchivoVehiculo() {
        this("Vehiculos.obj");
    }

    private Vehiculos leer() throws ExcepcionAcessoDatos {
        Vehiculos vehiculos;
        ObjectInputStream ois = null;

        if (this.archivo.exists()) {
            try {
                this.aLectura = new FileInputStream(this.archivo);
                ois = new ObjectInputStream(this.aLectura);
                vehiculos = (Vehiculos) ois.readObject();
                return vehiculos;
            } catch (IOException ioe) {
                throw new ExcepcionAcessoDatos("No se pudo leer el archivo.");
            } catch (ClassNotFoundException ex) {
                throw new ExcepcionAcessoDatos("La clase Publicaciones No existe");
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException ignored) {
                    }
                }
                if (this.aLectura != null) {
                    try {
                        this.aLectura.close();
                    } catch (IOException ignored) {
                    }
                }
            }
        }
        else{
            vehiculos = new Vehiculos();
            return vehiculos;
        }

    }

    private void guardar(Vehiculos vehiculos) throws ExcepcionAcessoDatos {
        ObjectOutputStream oos = null;
        try {
            this.aEscritura = new FileOutputStream(this.archivo, false);
            oos = new ObjectOutputStream(this.aEscritura);
            oos.writeObject(vehiculos);
        } catch (IOException ioe) {
            throw new ExcepcionAcessoDatos("No se pudo escribir en el archivo.");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ignored) {
                }
            }
            if (this.aEscritura != null) {
                try {
                    this.aEscritura.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    private Vehiculo getVehiculo(List<Vehiculo> vehiculos, String buscar) {
        for (Vehiculo p: vehiculos) {
            if (p.getnSerie().equals(buscar)) {
                return p;
            }
        }
        return null;
    }


    @Override
    public void agregarVehiculo(Vehiculo vehiculo) throws ExcepcionAcessoDatos {
        Vehiculos vehiculos = this.leer();
        vehiculos.lista.add(vehiculo);
        this.guardar(vehiculos);
    }

    @Override
    public List<Vehiculo> leerVehiculo() throws ExcepcionAcessoDatos {
        List<Vehiculo> vehiculos = this.leer().lista;
        if (vehiculos.isEmpty()) {
            throw new ExcepcionAcessoDatos("No hay publicaciones registradas");
        }
        return vehiculos;
    }

    @Override
    public Vehiculo mostrarVehiculo(String buscar) throws ExcepcionAcessoDatos {
        Vehiculo vehiculo = getVehiculo(this.leerVehiculo(),buscar);
        if (vehiculo == null) {
            throw new ExcepcionAcessoDatos("No existe publicacion");
        }
        return vehiculo;
    }

    @Override
    public void borrarVehiculo(String buscar) throws ExcepcionAcessoDatos {
        Vehiculos vehiculos = this.leer();
        Vehiculo vehiculo = getVehiculo(vehiculos.lista,buscar);
        if (vehiculos.lista.remove(vehiculo)) {
            this.archivo.delete();
            this.guardar(vehiculos);
        } else {
            throw new ExcepcionAcessoDatos("No se pudo borrar la publicación");
        }
    }

}
