package impl.Parcial;

import api.ColaPrioridadTDA;
import api.ColaTDA;
import api.ListaPromediadaTDA;
import impl.Estaticos.ColaPrioridadEstatica;
import impl.Aux.Nodo;
import impl.Dinamicos.ColaDinamica;

public class ListaPromediada implements ListaPromediadaTDA {
    Nodo primero;
    Nodo ultimo;
    float promedio;

    public void Inicializar() {
        primero = null;
        ultimo = null;
    }

    public void Agregar(int valor) {
        Nodo nuevo = new Nodo();
        nuevo.info = valor;
        

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        }
        else {
            promedio = Promedio();
            if (valor < promedio) {
                nuevo.sig = primero;
                primero = nuevo;
            } else if (valor > promedio) {
                nuevo.sig = null;
                ultimo.sig = nuevo;
                ultimo = nuevo;
            }
        }
    }

    public void Eliminar(int valor) {
        Nodo actual = primero;
        while (actual.sig.sig != null) {
            if (actual.sig.info == valor) {
                actual.sig = actual.sig.sig;
            }
            actual = actual.sig;
        }
    }

    public float Promedio() {
        Nodo actual = primero;
        float suma = 0;
        int contador = 0;
        while (actual != null) {
            suma += actual.info;
            contador++;
            actual = actual.sig;
        }
        float promedio = (suma / contador);
        return (promedio);
    }

    public ColaTDA Menores() {
        ColaPrioridadTDA menoresPrioridad = new ColaPrioridadEstatica();
        menoresPrioridad.InicializarCola();
        
        ColaTDA menores = new ColaDinamica();
        menores.InicializarCola();

        Nodo actual = primero;
        int contador = 0;

        while (actual != null) {
            if (actual.info < promedio) {
                menoresPrioridad.Acolar(actual.info, -actual.info);
                contador++;
            }
            actual = actual.sig;
        }

        for (int i = 0; i < contador; i++) {
            menores.Acolar(menoresPrioridad.Primero());
            menoresPrioridad.Desacolar();
        }

        return menores;
    }

    public ColaTDA Mayores() {
        ColaPrioridadTDA mayoresPrioridad = new ColaPrioridadEstatica();
        mayoresPrioridad.InicializarCola();

        ColaTDA mayores = new ColaDinamica();
        mayores.InicializarCola();

        Nodo actual = primero;
        int contador = 0;

        while (actual != null) {
            if (actual.info > promedio) {
                mayoresPrioridad.Acolar(actual.info, -actual.info);
                contador++;
            }
            actual = actual.sig;
        }

        for (int i = 0; i < contador; i++) {
            mayores.Acolar(mayoresPrioridad.Primero());
            mayoresPrioridad.Desacolar();
        }

        return mayores;
    }

    public boolean EstaVacia() {
        return (primero == null);
    }
}
