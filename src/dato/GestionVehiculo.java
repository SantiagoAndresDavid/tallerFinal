package dato;

import dominio.Vehiculo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionVehiculo implements IAccesoVehiculos {
    private File archivo;
    private FileWriter modoEscritura;
    private Scanner modoLectura;

    public GestionVehiculo() {
        this.archivo = new File("Vehiculos.dat");
    }

    public GestionVehiculo(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
    }


    private Vehiculo crearVehiculo(String linea) {

        String datos[] = linea.split(";");
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setTipo(datos[0]);
        vehiculo.setnSerie(datos[1]);
        vehiculo.setnAsientos(datos[2]);
        vehiculo.setModelo(datos[3]);
        vehiculo.setAño(datos[4]);
        vehiculo.setDisponibilidad(datos[5]);
        return vehiculo;
    }

    private void renombrarArchivo(File nvoArchivo) throws IOException {
        // se crea el archivo temporal si no existe
        if (!nvoArchivo.exists())
            nvoArchivo.createNewFile();

        //se elimina el archivo original
        if (!this.archivo.delete()) {
            throw new IOException("No fue posible eliminar el archivo original");
        }

        //se renombra el archivo temporal
        if (!nvoArchivo.renameTo(this.archivo)) {
            throw new IOException("No fue posible renombrar el archivo temporal");
        }
    }


    @Override
    public void insertarVehiculo(Vehiculo vehiculo) throws IOException {
        PrintWriter pw = null;
        try {
            this.modoEscritura = new FileWriter(this.archivo, true); // modo edicion
            pw = new PrintWriter(this.modoEscritura);
            pw.println(vehiculo.getDataText());
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (pw != null)
                pw.close();
            this.modoEscritura.close();
        }
    }

    @Override
    public List<Vehiculo> leerVehiculo() throws IOException {
        List<Vehiculo> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Vehiculo vehiculo = this.crearVehiculo(linea);
                listado.add(vehiculo);
            }
            return listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null)
                this.modoLectura.close();
        }
    }

    @Override
    public Vehiculo buscarVehiculo(String buscar) throws IOException {
        Vehiculo encontrado = null;
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Vehiculo vehiculo = this.crearVehiculo(linea);
                if (vehiculo.getnSerie().equalsIgnoreCase(buscar)) {
                    encontrado = vehiculo;
                    break;
                }
            }
            return encontrado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null)
                this.modoLectura.close();
        }
    }

    @Override
    public void eliminarVehiculo(String buscar) throws IOException {
        try {
            this.modoLectura = new Scanner(this.archivo);
            GestionVehiculo archivoTemporal = new GestionVehiculo("Temporal.dat");
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Vehiculo vehiculo = this.crearVehiculo(linea);
                if (!vehiculo.getnSerie().equalsIgnoreCase(buscar)) {// eliminar
                    archivoTemporal.insertarVehiculo(vehiculo);
                }
            }
            this.modoLectura.close();
            this.renombrarArchivo(archivoTemporal.archivo);
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            this.modoLectura.close();
        }
    }
}

