package Tests;

import api.ColaTDA;
import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import api.GestorDeReservasTDA;
import api.PilaTDA;
import impl.Parcial.GestorDeReservas;

public class TestGestorReservas {
    public static void main(String[] args) throws Exception {
        GestorDeReservasTDA gestorReservas = new GestorDeReservas();
        gestorReservas.Inicializar();
        //agregar 10 reservas
        System.out.println("Agregando 10 reservas(0-9)");
        for (int i = 0; i < 10; i++) {
            gestorReservas.agregarReserva(i, i, i, i, i);
            gestorReservas.obtenerReserva(i);
        }

        //eliminar 7 reservas en order
        PilaTDA pilaReservas;
        System.out.println("Eliminando 7 reservas(9-3)");
        for (int i = 9; i >= 3; i--) {
            gestorReservas.eliminarReserva(i);
            pilaReservas = gestorReservas.listaDeReservas();

            while(!(pilaReservas.PilaVacia())) {
                System.out.println(pilaReservas.Tope());
                pilaReservas.Desapilar();
            }

            System.out.println("____________________________");
            
        }

        // eliminar 2 reservas aleatoriamente
        System.out.println("Eliminando reservas 0 y 2");

        gestorReservas.eliminarReserva(0);
        gestorReservas.eliminarReserva(2);

        pilaReservas = gestorReservas.listaDeReservas();

        while(!(pilaReservas.PilaVacia())) {
            System.out.println(pilaReservas.Tope());
            pilaReservas.Desapilar();
        }
        System.out.println("____________________________");
        // elimino reserva 1 para limpiar el gestor y hacer otros tests

        gestorReservas.eliminarReserva(1);


        System.out.println("Agregando 10 reservas(0-9) al vuelo 4");
        for (int i = 0; i < 10; i++) {
            gestorReservas.agregarReserva(i, i, 4, i, i);
            gestorReservas.obtenerReserva(i);
        }
        System.out.println("Modificando asiento pasajero 3 del vuelo 4 a asiento 10");
        gestorReservas.actualizarAsiento(3, 3, 10);
        
        System.out.println("Actualizando vuelo de reserva 5 a vuelo nro 8");
        gestorReservas.actualizarVuelo(5, 8);

        for (int i = 0; i < 10; i++) {
            gestorReservas.obtenerReserva(i);
        }

        System.out.println("Actualizando fecha de reserva 6 a fecha 9");
        gestorReservas.actualizarFecha(6, 9);

        System.out.println("Mostrando todos las reservas del vuelo 4");
        ColaTDA reservasVuelo = gestorReservas.reservasPorVuelo(4);
        while (!reservasVuelo.ColaVacia()) {
            System.out.println(reservasVuelo.Primero());
            reservasVuelo.Desacolar();
        }

        System.out.println("Mostrando todas las reservas de la fecha 9");
        ConjuntoTDA reservasFecha = gestorReservas.reservasPorFecha(9);
        reservasFecha.MostrarConjunto();

        System.out.println("Mostrando diccionario de reservas con claves nro de vuelo y valor id de reserva");
        DiccionarioMultipleTDA  dicVuelos = gestorReservas.listarPorVuelo();
        System.out.println("nro de vuelo 4:");
        dicVuelos.Recuperar(4).MostrarConjunto();
        System.out.println("nro de vuelo 8");
        dicVuelos.Recuperar(8).MostrarConjunto();

        System.out.println("Mostrando diccionario de reservas por fecha");
        DiccionarioMultipleTDA dicFechas = gestorReservas.listarPorFecha();
        for (int i = 0; i < 10; i++) {
            ConjuntoTDA valores = dicFechas.Recuperar(i);
            if (valores.ConjuntoVacio()) {
                System.out.printf("No hay reservas para la fecha %d\n", i);
            } else {
                System.out.printf("Fecha: %d\n", i);
                System.out.printf("Reserva: %d\n",i);
                valores.MostrarConjunto();
            }
        }
    }
}