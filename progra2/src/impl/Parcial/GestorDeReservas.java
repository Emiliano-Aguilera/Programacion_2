package impl.Parcial;

import api.ColaTDA;
import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import api.GestorDeReservasTDA;
import api.PilaTDA;
import impl.Aux.NodoReserva;
import impl.Dinamicos.ColaDinamica;
import impl.Dinamicos.ConjuntoDinamico;
import impl.Dinamicos.DiccionarioMultipleDinamico;
import impl.Dinamicos.PilaDinamica;

public class GestorDeReservas implements GestorDeReservasTDA{
    NodoReserva primero;
    public void Inicializar() {
        primero = null;
    }

    public void agregarReserva(int id_reserva, int id_pasajero, int nro_vuelo, int nro_asiento, int fecha) {
        NodoReserva nuevo = new NodoReserva();
        nuevo.id_reserva = id_reserva;
        nuevo.id_pasajero = id_pasajero;
        nuevo.nro_vuelo = nro_vuelo;
        nuevo.nro_asiento = nro_asiento;
        nuevo.fecha = fecha;
        nuevo.sig = primero;
        primero = nuevo;
    }

    
    public void eliminarReserva(int id_reserva) {
        if(primero.id_reserva == id_reserva) {
            primero = primero.sig;
        } else {
            NodoReserva iterador = primero;
            NodoReserva anterior = primero;
            while (iterador.id_reserva != id_reserva) {
                anterior = iterador;
                iterador = iterador.sig;
            }
            anterior.sig = iterador.sig;
        }
    }

    
    public void actualizarAsiento(int id_reserva, int id_pasajero, int nro_asiento) {
        NodoReserva iterador = primero;
        while (iterador != null) {
            if(iterador.id_reserva == id_reserva && iterador.id_pasajero == id_pasajero) {
                break;
            }
            iterador = iterador.sig;
        }
        iterador.nro_asiento = nro_asiento;
    }

    
    public void actualizarVuelo(int id_reserva, int nro_vuelo) {
        NodoReserva iterador = primero;
        while(iterador.id_reserva != id_reserva){
            iterador = iterador.sig;
        }

        iterador.nro_vuelo = nro_vuelo;
    }

    
    public void actualizarFecha(int id_reserva, int fecha) {
        NodoReserva iterador = primero;
        while(iterador.id_reserva != id_reserva){
            iterador = iterador.sig;
        }

        iterador.fecha = fecha;
    }

    
    public void obtenerReserva(int id_reserva) {
        NodoReserva iterador = primero;
        while(iterador.id_reserva != id_reserva){
            iterador = iterador.sig;
        }

        System.out.printf("ID pasajero: %d \nNro de vuelo: %d\nNro de asiento: %d\n---------------\n",
                                    iterador.id_pasajero,
                                    iterador.nro_vuelo,
                                    iterador.nro_asiento);


    }

    
    public PilaTDA listaDeReservas() {
        NodoReserva iterador = primero;
        PilaTDA reservas = new PilaDinamica();
        reservas.InicializarPila();

        while(iterador != null){
            reservas.Apilar(iterador.id_reserva);
            iterador = iterador.sig;
        }

        return(reservas);
    }

    
    public ColaTDA reservasPorVuelo(int nro_vuelo) {
        NodoReserva iterador = primero;

        ColaTDA reservas = new ColaDinamica();
        reservas.InicializarCola();

        while(iterador != null){
            if(iterador.nro_vuelo == nro_vuelo) {
                reservas.Acolar(iterador.id_reserva);
            }

            iterador = iterador.sig;
        }

        return(reservas);
    }

    
    public ConjuntoTDA reservasPorFecha(int fecha) {
        NodoReserva iterador = primero;

        ConjuntoTDA reservas = new ConjuntoDinamico();
        reservas.InicializarConjunto();

        while(iterador != null){
            if(iterador.fecha == fecha) {
                reservas.Agregar(iterador.id_reserva);
            }

            iterador = iterador.sig;
        }

        return(reservas);
    }

    
    public DiccionarioMultipleTDA listarPorVuelo() {
        DiccionarioMultipleTDA vuelosReservas = new DiccionarioMultipleDinamico();
        vuelosReservas.InicializarDiccionario();
        NodoReserva iterador = primero;

        while(iterador != null){
            vuelosReservas.Agregar(iterador.nro_vuelo, iterador.id_reserva);
            iterador = iterador.sig;
        }

        return(vuelosReservas);
    }

    
    public DiccionarioMultipleTDA listarPorFecha() {
        DiccionarioMultipleTDA fechasVuelos = new DiccionarioMultipleDinamico();
        fechasVuelos.InicializarDiccionario();

        NodoReserva iterador = primero;

        while(iterador != null){
            fechasVuelos.Agregar(iterador.fecha, iterador.id_reserva);
            iterador = iterador.sig;
        }

        return(fechasVuelos);
    }

}
