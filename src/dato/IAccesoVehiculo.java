package dato;

import Exepciones.ExcepcionAcessoDatos;
import dominio.Vehiculo;

import java.util.List;

public interface IAccesoVehiculo {
    void agregarVehiculo(Vehiculo vehiculo) throws ExcepcionAcessoDatos;

    List<Vehiculo> leerVehiculo() throws ExcepcionAcessoDatos;

    Vehiculo mostrarVehiculo(String buscar) throws ExcepcionAcessoDatos;

    void borrarVehiculo(String buscar) throws ExcepcionAcessoDatos;

}
