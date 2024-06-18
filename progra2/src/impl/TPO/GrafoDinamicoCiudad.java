package impl.TPO;

import api.TPO.ConjuntoCiudadTDA;
import api.TPO.GrafoCiudadTDA;

public class GrafoDinamicoCiudad implements GrafoCiudadTDA {
    class NodoAristaCiudad {
        int etiqueta;
        nodoGrafoCiudad nodoDestino;
        NodoAristaCiudad sigArista;
    }

    class nodoGrafoCiudad {
        String ciudad;
        String provincia;
        NodoAristaCiudad arista;
        nodoGrafoCiudad sigNodo;
    }

    nodoGrafoCiudad origen;

    @Override
    public void InicializarGrafo() {
        origen = null;
    }

    @Override
    public void AgregarVertice(String ciudad, String provincia) {
        nodoGrafoCiudad aux = new nodoGrafoCiudad();
        aux.ciudad = ciudad;
        aux.provincia = provincia;
        aux.arista = null;
        aux.sigNodo = origen;
        origen = aux;
    }

    @Override
    public void EliminarVertice(String ciudad, String provincia) {
        if (origen.ciudad == ciudad && origen.provincia == provincia) {
            origen = origen.sigNodo;
        }

        nodoGrafoCiudad aux = origen;
        
        while (aux != null) {
            this.EliminarAristaNodo(aux, ciudad);
            if (aux.sigNodo != null && aux.sigNodo.ciudad == ciudad) {
                aux.sigNodo = aux.sigNodo.sigNodo;
            }
            aux = aux.sigNodo;
        }
    }

    @Override
    public ConjuntoCiudadTDA Vertices() {
        ConjuntoCiudadTDA c = new ConjuntoCiudadDinamico();
        c.InicializarConjunto();

        nodoGrafoCiudad aux = origen;
        while (aux != null) {
            c.Agregar(aux.ciudad);
            aux = aux.sigNodo;
        }
        return c;
    }

    @Override
    public ConjuntoCiudadTDA VerticesProvincia() { // Devuelve las provincias
        ConjuntoCiudadTDA c = new ConjuntoCiudadDinamico();
        c.InicializarConjunto();

        nodoGrafoCiudad aux = origen;
        while (aux != null) {
            c.Agregar(aux.provincia);
            aux = aux.sigNodo;
        }
        return c;
    }

    @Override
    public void AgregarArista(String ciudad1, String ciudad2, int kilometros) {
        nodoGrafoCiudad n1 = Vert2Nodo(ciudad1);
        nodoGrafoCiudad n2 = Vert2Nodo(ciudad2);

        NodoAristaCiudad aux = new NodoAristaCiudad();
        aux.etiqueta = kilometros;
        aux.nodoDestino = n2;
        aux.sigArista = n1.arista;
        n1.arista = aux;
    }

    @Override
    public void EliminarArista(String ciudad1, String ciudad2) {
        nodoGrafoCiudad n1 = Vert2Nodo(ciudad1);
        EliminarAristaNodo(n1, ciudad2);
    }

    @Override
    public boolean ExisteArista(String ciudad1, String ciudad2) {
        nodoGrafoCiudad n1 = Vert2Nodo(ciudad1);

        NodoAristaCiudad aux = n1.arista;

        while (aux != null && aux.nodoDestino != null && aux.nodoDestino.ciudad != ciudad2) {
            aux = aux.sigArista;
        }
        return aux != null;
    }

    @Override
    public int PesoArista(String ciudad1, String ciudad2) {
        nodoGrafoCiudad n1 = Vert2Nodo(ciudad1);

        NodoAristaCiudad aux = n1.arista;
        while (aux.nodoDestino.ciudad != ciudad2) {
            aux = aux.sigArista;
        }
        return aux.etiqueta;
    }

    private nodoGrafoCiudad Vert2Nodo(String Ciudad) {
        nodoGrafoCiudad aux = origen;
        while (aux != null && aux.ciudad != Ciudad) {
            aux = aux.sigNodo;
        }
        return aux;
    }

    private void EliminarAristaNodo(nodoGrafoCiudad nodo, String ciudad) {
        NodoAristaCiudad aux = nodo.arista;

        if (aux != null) {
            if (aux.nodoDestino.ciudad == ciudad) {
                nodo.arista = aux.sigArista;
            } else {
                while (aux.sigArista != null && aux.sigArista.nodoDestino.ciudad != ciudad) {
                    aux = aux.sigArista;
                }
                if (aux.sigArista != null) {
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }
    }
}
