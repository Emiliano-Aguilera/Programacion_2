package impl.Dinamicos;

import api.ColaPrioridadTDA;
import impl.Aux.NodoColaPrioridad;

public class ColaPrioridadDinamica implements ColaPrioridadTDA{
    NodoColaPrioridad primero;

    public void InicializarCola() {
        primero = null;
    }

    public void Acolar(int valor, int prioridad) {
        NodoColaPrioridad nuevo = new NodoColaPrioridad();
        nuevo.valor = valor;
        nuevo.prioridad = prioridad;
        
        if(primero != null) {
            Insertar(primero, nuevo);
        } else {
            primero = nuevo;
        }
    }

    public void Desacolar() {
        primero = primero.siguiente;
    }

    public int Primero() {
        return(primero.valor);
    }

    public boolean ColaVacia() {
        return (primero == null);
    }

    public int Prioridad() {
        return (primero.prioridad);
    }

    private void Insertar(NodoColaPrioridad _primero, NodoColaPrioridad _nuevo) {
        if(_primero.prioridad < _nuevo.prioridad) {
            _nuevo.siguiente = _primero.siguiente;
            _primero = _nuevo;
        } else {
            NodoColaPrioridad actual = _primero;
            while (actual.siguiente != null && actual.prioridad > _nuevo.prioridad) {
                actual = actual.siguiente;
            }
            _nuevo.siguiente = actual.siguiente;
            actual.siguiente = _nuevo;
        }    
    }
}
