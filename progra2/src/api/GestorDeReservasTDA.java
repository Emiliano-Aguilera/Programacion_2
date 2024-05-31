package api;

public interface GestorDeReservasTDA {
    void Inicializar();
    void agregarReserva(int id_reserva, int id_pasajero, int nro_vuelo, int nro_asiento, int fecha);
    void eliminarReserva(int id_reserva);
    void actualizarAsiento(int id_reserva, int id_pasajero, int nro_asiento);
    void actualizarVuelo(int id_reserva, int nro_vuelo);
    void actualizarFecha(int id_reserva, int fecha);
    void obtenerReserva(int id_reserva);
    PilaTDA listaDeReservas();
    ColaTDA reservasPorVuelo(int nro_vuelo);
    ConjuntoTDA reservasPorFecha(int fecha);
    DiccionarioMultipleTDA listarPorVuelo();
    DiccionarioMultipleTDA listarPorFecha();
}
