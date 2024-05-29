package impl.Dinamicos;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import impl.Aux.NodoDiccionarioMultiple;

public class DiccionarioMultipleDinamico implements DiccionarioMultipleTDA {
    NodoDiccionarioMultiple primero;
    ConjuntoTDA claves;

    public void InicializarDiccionario() {
        primero = null;

        claves = new ConjuntoDinamico();
        claves.InicializarConjunto();
    }

    public void Agregar(int clave, int valor) {
        if (claves.Pertenece(clave)) {
            NodoDiccionarioMultiple iterador = primero;

            while (iterador.clave != clave) {
                iterador = iterador.sig;
            }

            iterador.valores.Agregar(valor);
        } else {
            NodoDiccionarioMultiple nuevo = new NodoDiccionarioMultiple();
            nuevo.InicializarNodo();

            nuevo.clave = clave;
            nuevo.valores.Agregar(valor);
            nuevo.sig = primero;

            primero = nuevo;

            claves.Agregar(clave);
        }
    }

    public ConjuntoTDA Recuperar(int clave) {
        NodoDiccionarioMultiple iterador = primero;
        ConjuntoTDA valores = new ConjuntoDinamico();
        valores.InicializarConjunto();

        while (iterador != null) {
            if (iterador.clave == clave) {
                valores = iterador.valores;
                break;
            }
            iterador = iterador.sig;
        }

        return valores;
    }

    public void Eliminar(int clave) {
        if (primero.clave == clave) {
            primero = primero.sig;
        } else {
            NodoDiccionarioMultiple iterador = primero.sig;
            NodoDiccionarioMultiple anterior = primero;

            while(iterador.clave != clave) {
                anterior = iterador;
                iterador = iterador.sig;
            }

            anterior.sig = iterador.sig;
            claves.Sacar(clave);
        }
    }

    public void EliminarValor(int clave, int valor) {
        NodoDiccionarioMultiple iterador = primero;

        while (iterador != null) {
            if (iterador.clave == clave) {
                iterador.valores.Sacar(valor);

                if (iterador.valores.ConjuntoVacio()) {
                    Eliminar(clave);
                }

                break;
            }
            iterador = iterador.sig;
        }
    }

    public ConjuntoTDA Claves() {
        return claves;
    }
}
