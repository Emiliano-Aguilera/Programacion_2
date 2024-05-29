package impl.Estaticos;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import impl.Aux.ElementoDiccionarioMultiple;

public class DiccionarioMultipleEstatico implements DiccionarioMultipleTDA {
    int indice;
    ConjuntoTDA claves;
    ElementoDiccionarioMultiple[] vectorDiccionario;

    public void InicializarDiccionario() {
        indice = 0;
        claves = new ConjuntoEstatico();
        claves.InicializarConjunto();
        vectorDiccionario = new ElementoDiccionarioMultiple[100];
    }

    public void Agregar(int clave, int valor) {
        if (ClaveUsada(clave)) {
            int indiceClave = BuscarClave(clave);
            vectorDiccionario[indiceClave].valores.Agregar(valor);
        } else {
            claves.Agregar(clave);

            vectorDiccionario[indice].Inicializar();
            vectorDiccionario[indice].clave = clave;
            vectorDiccionario[indice].valores.Agregar(valor);

            indice++;
        }
    }

    public void Eliminar(int clave) {
        int indiceClave = BuscarClave(clave);
        vectorDiccionario[indiceClave] = vectorDiccionario[indice--];
        claves.Sacar(clave);
    }

    public void EliminarValor(int clave, int valor) {
        int indiceClave = BuscarClave(clave);
        vectorDiccionario[indiceClave].valores.Sacar(valor);
        
        if (vectorDiccionario[indiceClave].valores.ConjuntoVacio()) {
            vectorDiccionario[indiceClave] = vectorDiccionario[indice--];
            claves.Sacar(clave);
        }
    }

    public ConjuntoTDA Recuperar(int clave) {
        if (ClaveUsada(clave)) {
            int indiceClave = BuscarClave(clave);
            return (vectorDiccionario[indiceClave].valores);
        } else {
            ConjuntoTDA conjuntoVacio = new ConjuntoEstatico();
            conjuntoVacio.InicializarConjunto();
            return (conjuntoVacio);
        }
    }

    public ConjuntoTDA Claves() {
        return claves;
    }

    private Boolean ClaveUsada(int clave) {
        return (claves.Pertenece(clave));
    }

    private int BuscarClave(int clave) {
        int i = 0;
        Boolean claveEncontrada = false;

        while (!claveEncontrada && i < indice) {
            if (vectorDiccionario[i].clave == clave) {
                claveEncontrada = true;
            }
        }

        if (claveEncontrada) {
            return i;
        } else {
            return -1;
        }
    }
}
