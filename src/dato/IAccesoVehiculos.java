package dato;

import dominio.Vehiculo;

import java.io.IOException;
import java.util.List;

public interface IAccesoVehiculos {
    void insertarVehiculo(Vehiculo vehiculo) throws IOException;
    List<Vehiculo> leerVehiculo()throws IOException;
    Vehiculo buscarVehiculo(String buscar)throws IOException;
    void eliminarVehiculo(String buscar)throws IOException;
}
