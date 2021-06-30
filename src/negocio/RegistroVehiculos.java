package negocio;


import Exepciones.ExcepcionAcessoDatos;
import dato.ArchivoVehiculo;
import dato.IAccesoVehiculo;
import dominio.Vehiculo;

import java.util.List;

public class RegistroVehiculos {
    private final IAccesoVehiculo datos;

    public RegistroVehiculos() {
        this.datos = new ArchivoVehiculo();
    }

    public void insertar(Vehiculo vehiculo) {
        try {
            datos.agregarVehiculo(vehiculo);
        } catch (ExcepcionAcessoDatos excepcionAcessoDatos) {
            excepcionAcessoDatos.printStackTrace();
        }
    }

    public List<Vehiculo> leer() {
        try {
            return datos.leerVehiculo();
        } catch (ExcepcionAcessoDatos excepcionAcessoDatos) {
            excepcionAcessoDatos.printStackTrace();
        }
        return null;
    }

    public Vehiculo buscarPor(String buscar)  {
        try {
            return datos.mostrarVehiculo(buscar);
        } catch (ExcepcionAcessoDatos excepcionAcessoDatos) {
            excepcionAcessoDatos.printStackTrace();
        }
        return null;
    }


    public void eliminar(String buscar) {
        try {
            datos.borrarVehiculo(buscar);
        } catch (ExcepcionAcessoDatos excepcionAcessoDatos) {
            excepcionAcessoDatos.printStackTrace();
        }
    }

}
