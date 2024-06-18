package impl.TPO;

import api.TPO.ConjuntoCiudadTDA;
import api.TPO.TPOTDA;

public class Main {
    public static void main(String[] args) {
        TPOTDA t1 = new TPOimplementacion();
        ConjuntoCiudadTDA c1 = new ConjuntoCiudadDinamico();
        c1.InicializarConjunto();
        
        t1.inicializar();
        t1.CargarCiudadesPrueba();
        //---------------------------------------------------------------
        // Listar Ciudades, Listar Provincias, Cargar,Eliminar:
        System.out.println("Listado de provincias: ");
        System.out.println();
        c1 = t1.listarProvincias();
        c1.imprimir(c1);
        System.out.println();
        System.out.println("Listado de ciudades: ");
        System.out.println();
        c1 = t1.listarCiudades();
        c1.imprimir(c1);  

        //----------------------------------------------------------------
        // Punto 2 Ciudades vecinas
        System.out.println("--------------------------------------------");
        System.out.println("Punto 2 Ciudades vecinas: ");
        System.out.println();
        c1 = t1.ciudadesVecinas("CABA");
        //----------------------------------------------------------------
        // Punto 3 Ciudades puente:
        System.out.println("--------------------------------------------");
        System.out.println("Punto 3 Ciudades puente: ");
        System.out.println();
        c1 = t1.ciudadesPuente("CABA", "Ciudad de Cordoba");
        //----------------------------------------------------------------
        // Punto 4 Ciudades predecesoras
        System.out.println("--------------------------------------------");
        System.out.println("Punto 4 Ciudades predecesoras: ");
        System.out.println();
        c1 = t1.ciudadesPredecesoras("CABA");
        //----------------------------------------------------------------
        // Punto 5 Ciudades extremo
        System.out.println("--------------------------------------------");
        System.out.println("Punto 5 Ciudades extremo: ");
        System.out.println();
        System.out.println("Las ciudades extremo son: ");
        System.out.println();
        c1 = t1.ciudadesExtremo();
        //----------------------------------------------------------------
        // Punto 6 Ciudades fuertemente conectadas
        System.out.println("--------------------------------------------");
        System.out.println("Punto 6 ciudades fuertemente conectadas");
        t1.listarCiudadesFuertementeConectadas();

        //----------------------------------------------------------------
        // Punto 7 calcular camino
        System.out.println("--------------------------------------------");
        System.out.println("Punto 7 calcular Camino");
        
        System.out.println(t1.calcularCamino("CABA", "Trelew"));

        System.out.println(t1.calcularCamino("Puerto Madryn","Rio Cuarto"));
        
    }
}
