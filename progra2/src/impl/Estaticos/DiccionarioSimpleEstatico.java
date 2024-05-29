package impl.Estaticos;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;
import impl.Aux.ElementoDiccionarioSimple;

public class DiccionarioSimpleEstatico implements DiccionarioSimpleTDA {
    int indice;
    ConjuntoTDA claves;
    ElementoDiccionarioSimple[] vectorDiccionario;

    public void InicializarDiccionario() {
        indice = 0;
        claves = new ConjuntoEstatico();
        claves.InicializarConjunto();
        vectorDiccionario = new ElementoDiccionarioSimple[100];
    }

    public void Agregar(int clave, int valor) {
        if (!ClaveUsada(clave)) {
            claves.Agregar(clave);

            vectorDiccionario[indice].clave = clave;
            vectorDiccionario[indice].valor = valor;

            indice++;
        } else {
            int indiceClave = BuscarClave(clave);
            vectorDiccionario[indiceClave].valor = valor;
        }
    }

    public void Eliminar(int clave) {
        int indiceClave = BuscarClave(clave);

        vectorDiccionario[indiceClave] = vectorDiccionario[indice-1];
        claves.Sacar(clave);
        
        indice--;
    }

    public int Recuperar(int clave) {
        int indiceClave = BuscarClave(clave);
        return (vectorDiccionario[indiceClave].valor);
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

        return i;
    }
}
