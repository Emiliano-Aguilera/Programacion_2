package impl.Guia;

import api.ColaPrioridadTDA;
import impl.Aux.NodoColaPrioridad;

public class ColaPrioridadLD implements ColaPrioridadTDA{
    NodoColaPrioridad mayorPrioridad;

    public void InicializarCola(){
        mayorPrioridad = null;
    }

    public void Acolar(int valor, int prioridad){
        NodoColaPrioridad nuevo = new NodoColaPrioridad();
        nuevo.valor = valor;
        nuevo.prioridad = prioridad;

        if(mayorPrioridad == null || prioridad > mayorPrioridad.prioridad) {
            nuevo.siguiente = mayorPrioridad;
            mayorPrioridad = nuevo;
        } else {
            NodoColaPrioridad aux = mayorPrioridad;


            while(aux.siguiente != null && aux.siguiente.prioridad >= prioridad) {
                aux = aux.siguiente;
            }

            nuevo.siguiente = aux.siguiente;
            aux.siguiente = nuevo;
        }
    }

    public void Desacolar(){
        mayorPrioridad = mayorPrioridad.siguiente;
    }

    public int Primero(){
        return(mayorPrioridad.valor);
    }
    public boolean ColaVacia(){
        return(mayorPrioridad == null);
    }

    public int Prioridad() {
        return(mayorPrioridad.prioridad);
    }
}
