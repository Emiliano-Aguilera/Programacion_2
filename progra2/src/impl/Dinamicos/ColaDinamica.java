package impl.Dinamicos;

import api.ColaTDA;
import impl.Aux.Nodo;

public class ColaDinamica implements ColaTDA {
    Nodo primero;
    Nodo ultimo;

    public void InicializarCola() {
        primero = null;
        ultimo = null;
    }

    public void Acolar(int elemento) {
        Nodo nuevoElemento = new Nodo();

        nuevoElemento.info = elemento;
        nuevoElemento.sig = null;


        if (primero == null) {
            primero = nuevoElemento;
            ultimo = nuevoElemento;
        } else {
            ultimo.sig = nuevoElemento;
            ultimo = nuevoElemento;
        }
    }

    public void Desacolar() {
        primero = primero.sig;
    }

    public int Primero() {
        return primero.info;
    }

    public boolean ColaVacia() {
        return (primero == null);
    }
}
