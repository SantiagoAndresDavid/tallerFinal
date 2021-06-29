package negocio;

import dato.GestionUsuario;
import dato.GestionVehiculo;
import dato.IAccesoUsuarios;
import dato.IAccesoVehiculos;
import dominio.Usuario;
import dominio.Vehiculo;

import java.io.IOException;
import java.util.List;

public class RegistroVehiculos {
    private IAccesoVehiculos datos;

    public RegistroVehiculos() {
        this.datos = new GestionVehiculo();
    }

    public void insertar(Vehiculo vehiculo) throws IOException {
        datos.insertarVehiculo(vehiculo);
    }

    public List<Vehiculo> leer() {
        try {
            return datos.leerVehiculo();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Vehiculo buscarPor(String buscar) {
        try {
            return datos.buscarVehiculo(buscar);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void eliminar(String buscar) {
        try {
            datos.eliminarVehiculo(buscar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
