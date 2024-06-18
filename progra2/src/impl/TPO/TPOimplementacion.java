package impl.TPO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import api.TPO.ConjuntoCiudadTDA;
import api.TPO.GrafoCiudadTDA;
import api.TPO.TPOTDA;

public class TPOimplementacion implements TPOTDA {
    GrafoCiudadTDA grafo = new GrafoDinamicoCiudad();

    public void inicializar() {
        grafo.InicializarGrafo();
    }

    public ConjuntoCiudadTDA listarProvincias() {
        return grafo.VerticesProvincia();
    }

    public ConjuntoCiudadTDA listarCiudades() {
        return grafo.Vertices();
    }

    public void cargarCiudad(String ciudad, String provincia) {
        grafo.AgregarVertice(ciudad, provincia);
    }

    public void eliminarCiudad(String ciudad, String provincia) {
        grafo.EliminarVertice(ciudad, provincia);
    }

    public void AniadirRuta(String ciudad1, String ciudad2, int Kilometros) {
        grafo.AgregarArista(ciudad1, ciudad2, Kilometros);
    }

    public ConjuntoCiudadTDA ciudadesVecinas(String ciudad) {
        ConjuntoCiudadTDA vecinas = new ConjuntoCiudadDinamico();
        ConjuntoCiudadTDA ciudades = grafo.Vertices();

        if (ciudades.Pertenece(ciudad)) {
            System.out.println("Ciudades vecinas de " + ciudad + " :");
            while (!ciudades.ConjuntoVacio()) {
                String ciudadConjunto = ciudades.Elegir();
                if (grafo.ExisteArista(ciudad, ciudadConjunto)) {
                    vecinas.Agregar(ciudadConjunto);
                    System.out.println("Vecino encontrado: " + ciudadConjunto);
                }
                ciudades.Sacar(ciudadConjunto);
            }
        } else {
            System.out.println("No existe tal ciudad.");
        }

        return vecinas;
    }

    private ConjuntoCiudadTDA ciudadesVecinasNoImprime(String ciudad) { // Para usarlo en ciudades extremo
        ConjuntoCiudadTDA vecinas = new ConjuntoCiudadDinamico();
        ConjuntoCiudadTDA ciudades = grafo.Vertices();

        if (ciudades.Pertenece(ciudad)) {
            while (!ciudades.ConjuntoVacio()) {
                String ciudadConjunto = ciudades.Elegir();
                if (grafo.ExisteArista(ciudad, ciudadConjunto)) {
                    vecinas.Agregar(ciudadConjunto);

                }
                ciudades.Sacar(ciudadConjunto);
            }
        }

        return vecinas;

    }

    public ConjuntoCiudadTDA ciudadesPuente(String ciudadA, String ciudadB) {
        ConjuntoCiudadTDA puentes = new ConjuntoCiudadDinamico();
        ConjuntoCiudadTDA ciudades = grafo.Vertices();

        System.out.println("Puentes entre " + ciudadA + " y " + ciudadB + " :");
        if (ciudades.Pertenece(ciudadA) && ciudades.Pertenece(ciudadB)) {

            while (!ciudades.ConjuntoVacio()) {
                String ciudadConjunto = ciudades.Elegir();
                // Verificar si hay una ruta desde A hasta ciudadConjunto y desde ciudadConjunto
                // hasta B
                if (grafo.ExisteArista(ciudadA, ciudadConjunto) && grafo.ExisteArista(ciudadConjunto, ciudadB)) {
                    puentes.Agregar(ciudadConjunto);
                    int distanciaAPuente = grafo.PesoArista(ciudadA, ciudadConjunto);
                    int distanciaPuenteAB = grafo.PesoArista(ciudadConjunto, ciudadB);
                    int distanciaTotal = distanciaAPuente + distanciaPuenteAB;
                    System.out.printf("Puente encontrado: %s\n", ciudadConjunto);
                    // System.out.println("Puente encontrado: " + ciudadConjunto);
                    System.out.printf("Distancia desde %s hasta %s : %dKm\n", ciudadA, ciudadConjunto,
                            distanciaAPuente);
                    // System.out.println("Distancia desde " + ciudadA + " hasta " + ciudadConjunto
                    // + ": "
                    // + distanciaAPuente + " Km");
                    System.out.printf("Distancia desde %s hasta %s : %dKm\n", ciudadConjunto, ciudadB,
                            distanciaPuenteAB);
                    // System.out.println("Distancia desde " + ciudadConjunto + " hasta " + ciudadB
                    // + ": "
                    // + distanciaPuenteAB + " Km");
                    System.out.println("Distancia total " + distanciaTotal + "Km");
                    System.out.println();
                }
                ciudades.Sacar(ciudadConjunto);
            }
        }

        return puentes;
    }

    public ConjuntoCiudadTDA ciudadesPredecesoras(String ciudadA) {
        ConjuntoCiudadTDA predecesoras = new ConjuntoCiudadDinamico();
        ConjuntoCiudadTDA ciudades = grafo.Vertices();

        if (ciudades.Pertenece(ciudadA)) {

            int encontrado = 0;
            while (!ciudades.ConjuntoVacio()) {
                String ciudadConjunto = ciudades.Elegir();
                if (grafo.ExisteArista(ciudadConjunto, ciudadA)) {
                    encontrado++;
                    if (encontrado == 1) {
                        System.out.println("Ciudades predecesoras de " + ciudadA + ":");
                        System.out.println();
                    }
                    System.out.println(ciudadConjunto);

                    predecesoras.Agregar(ciudadConjunto);
                }
                ciudades.Sacar(ciudadConjunto);
            }
            if (predecesoras.ConjuntoVacio() == true) {
                System.out.println("No tiene predecesoras");
            }
        }

        return predecesoras;
    }

    public ConjuntoCiudadTDA ciudadesExtremo() {

        ConjuntoCiudadTDA ciudades = grafo.Vertices();
        ConjuntoCiudadTDA extremos = new ConjuntoCiudadDinamico();
        extremos.InicializarConjunto();

        System.out.println("Ciudades Extremos son:");
        while (!ciudades.ConjuntoVacio()) {
            String ciudadConjunto = ciudades.Elegir();
            if (this.ciudadesVecinasNoImprime(ciudadConjunto).ConjuntoVacio()) {
                extremos.Agregar(ciudadConjunto);
                System.out.println(ciudadConjunto);
            }
            ciudades.Sacar(ciudadConjunto);
        }
        return extremos;
    }

    public String calcularCamino(String ciudadA, String ciudadB) {
        // Estructuras auxiliares
        Queue<String> cola = new LinkedList<>();
        Map<String, String> padre = new HashMap<>(); // Para mantener el camino recorrido
        Set<String> visitados = new HashSet<>();

        // Inicialización
        cola.add(ciudadA);
        visitados.add(ciudadA);
        padre.put(ciudadA, null);

        // BFS
        while (!cola.isEmpty()) {
            String ciudadActual = cola.poll();

            // Si encontramos ciudadB, reconstruimos el camino y lo retornamos
            if (ciudadActual.equals(ciudadB)) {
                return reconstruirCamino(padre, ciudadA, ciudadB);
            }

            // Obtenemos los vecinos de la ciudadActual
            ConjuntoCiudadTDA vecinos = ciudadesVecinasNoImprime(ciudadActual);
            while (!vecinos.ConjuntoVacio()) {
                String vecino = vecinos.Elegir();
                vecinos.Sacar(vecino);
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                    padre.put(vecino, ciudadActual); // Registramos cómo llegamos a vecino desde ciudadActual
                }
            }
        }

        // Si llegamos aquí, no se encontró camino entre ciudadA y ciudadB
        return "No se encontró camino entre " + ciudadA + " y " + ciudadB;
    }

    // Método auxiliar para reconstruir el camino desde ciudadA hasta ciudadB
    private String reconstruirCamino(Map<String, String> padre, String ciudadA, String ciudadB) {
        List<String> camino = new ArrayList<>();
        String paso = ciudadB;
        while (paso != null) {
            camino.add(paso);
            paso = padre.get(paso);
        }
        Collections.reverse(camino);

        // Construimos la cadena de camino con las ciudades y la distancia total
        StringBuilder sb = new StringBuilder();
        sb.append("Camino encontrado entre ").append(ciudadA).append(" y ").append(ciudadB).append(": ");
        sb.append(camino.get(0));
        for (int i = 1; i < camino.size(); i++) {
            sb.append(" -> ").append(camino.get(i));
        }
        sb.append(". Distancia total: ").append(calcularDistancia(camino)).append(" Km");

        return sb.toString();
    }

    // Método para calcular la distancia total recorrida en el camino encontrado
    private int calcularDistancia(List<String> camino) {
        int distanciaTotal = 0;
        for (int i = 0; i < camino.size() - 1; i++) {
            String ciudadActual = camino.get(i);
            String ciudadSiguiente = camino.get(i + 1);
            distanciaTotal += grafo.PesoArista(ciudadActual, ciudadSiguiente);
        }
        return distanciaTotal;
    }

    public void CargarCiudadesPrueba() {
        this.cargarCiudad("La Plata", "Buenos Aires");
        this.cargarCiudad("Mar del Plata", "Buenos Aires");
        this.cargarCiudad("CABA", "Buenos Aires");
        this.cargarCiudad("Tandil", "Buenos Aires");

        this.cargarCiudad("Ciudad de Cordoba", "Cordoba");
        this.cargarCiudad("Rio Cuarto", "Cordoba");
        this.cargarCiudad("Villa Carlos Paz", "Cordoba");

        this.cargarCiudad("Cafayate", "Salta");

        this.cargarCiudad("Rawson", "Chubut");
        this.cargarCiudad("Trelew", "Chubut");
        this.cargarCiudad("Puerto Madryn", "Chubut");

        // añiado aristas

        this.AniadirRuta("CABA", "Mar del Plata", 400);
        this.AniadirRuta("CABA", "La Plata", 60);
        this.AniadirRuta("CABA", "Tandil", 350);
        this.AniadirRuta("CABA", "Ciudad de Cordoba", 1300);

        this.AniadirRuta("Mar del Plata", "CABA", 500);
        this.AniadirRuta("Mar del Plata", "Ciudad de Cordoba", 1800);

        this.AniadirRuta("La Plata", "Ciudad de Cordoba", 1500);
        this.AniadirRuta("La Plata", "Rawson", 2700);

        this.AniadirRuta("Tandil", "CABA", 480);

        this.AniadirRuta("Ciudad de Cordoba", "Rawson", 2800);
        this.AniadirRuta("Ciudad de Cordoba", "Rio Cuarto", 200);

        this.AniadirRuta("Rio Cuarto", "Puerto Madryn", 1150);

        this.AniadirRuta("Villa Carlos Paz", "Ciudad de Cordoba", 40);
        this.AniadirRuta("Villa Carlos Paz", "Rio Cuarto", 250);
        this.AniadirRuta("Villa Carlos Paz", "Trelew", 1400);

        this.AniadirRuta("Rawson", "Villa Carlos Paz", 1200);
        this.AniadirRuta("Rawson", "Cafayate", 2200);
        this.AniadirRuta("Rawson", "Trelew", 20);
    }

    public void listarCiudadesFuertementeConectadas() {
        ConjuntoCiudadTDA ciudades = grafo.Vertices(); // Obtener conjunto de todas las ciudades
        ConjuntoCiudadTDA ciudadesFuertementeConectadas = new ConjuntoCiudadDinamico();
        ciudadesFuertementeConectadas.InicializarConjunto();

        // Recorrer todas las ciudades en el grafo
        while (!ciudades.ConjuntoVacio()) {
            String ciudad1 = ciudades.Elegir();
            ciudades.Sacar(ciudad1);

            ConjuntoCiudadTDA ciudadesRestantes = grafo.Vertices(); // Copiar conjunto de todas las ciudades

            // Verificar rutas de ida y vuelta entre ciudad1 y cada otra ciudad
            while (!ciudadesRestantes.ConjuntoVacio()) {
                String ciudad2 = ciudadesRestantes.Elegir();
                ciudadesRestantes.Sacar(ciudad2);

                // Si existe ruta de ida y vuelta entre ciudad1 y ciudad2
                if (grafo.ExisteArista(ciudad1, ciudad2) && grafo.ExisteArista(ciudad2, ciudad1)) {
                    if(!ciudadesFuertementeConectadas.Pertenece(ciudad1) || !ciudadesFuertementeConectadas.Pertenece(ciudad2)){
                        System.out.printf("Las ciudades %s y %s estan fuertemente conectadas.\n", ciudad1, ciudad2);
                    }
                    ciudadesFuertementeConectadas.Agregar(ciudad1);
                    ciudadesFuertementeConectadas.Agregar(ciudad2);
                }
            }
        }

        // Imprimir las ciudades fuertemente conectadas encontradas
        if(ciudadesFuertementeConectadas.ConjuntoVacio()){
            System.out.println("No hay ciudades fuertemente conectadas registradas.");
        }
    }

}
