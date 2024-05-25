package impl.Dinamicos;

import api.ConjuntoTDA;
import impl.Aux.Nodo;

public class ConjuntoDinamico implements ConjuntoTDA {
    Nodo indice;
    int contador;

    public void InicializarConjunto() {
        indice = null;
        contador = 0;
    }

    public boolean ConjuntoVacio() {
        return(indice == null);
    }

    public void Agregar(int elemento) {
        if(!Pertenece(elemento)){
            Nodo nodo = new Nodo();
            nodo.info = elemento;
            nodo.sig = indice;
            indice = nodo;
            contador++;
        }
        
    }

    public void Sacar(int elemento) {
        Nodo anterior = indice;
        Nodo iterador = indice;
        
        if(indice.info == elemento){
            indice = indice.sig;
        } else {
            while(iterador != null) {
                if(iterador.info == elemento) {
                    anterior.sig = iterador.sig;
                    contador--;
                    break;
                }
                anterior = iterador;
                iterador = iterador.sig;
            }
        }
    }

    public boolean Pertenece(int elemento) {
        Nodo actual = indice;
        boolean pertenece = false;

        while(actual != null) {
            if(actual.info == elemento) {
                pertenece = true;
                break;
            }
            actual = actual.sig;
        }        
        return(pertenece);
    }

    public int Elegir() {
        if(contador > 1) {
            int elementoRandom = Math.abs((int)System.currentTimeMillis() % (contador - 1));
            Nodo actual = indice;
            for(int i = 0; i < elementoRandom; i++) {
                actual = actual.sig;
            }
            return(actual.info);
        } else {
            return(indice.info);
        }
    }

    public void MostrarConjunto(){
        Nodo actual = indice;

        for(int i = 0; i < contador; i++) {
            System.out.println(actual.info);
            actual = actual.sig;
        }
        System.out.println("----------------------------------");
    }
}