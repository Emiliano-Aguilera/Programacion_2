package impl.Dinamicos;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;
import impl.Aux.NodoDiccionarioSimple;

public class DiccionarioSimpleDinamico implements DiccionarioSimpleTDA {
    NodoDiccionarioSimple primero;
    ConjuntoTDA claves;

    public void InicializarDiccionario() {
        primero = null;

        claves = new ConjuntoDinamico();
        claves.InicializarConjunto();
    }

    public void Agregar(int clave, int valor) {
        if (claves.Pertenece(clave)) {
            NodoDiccionarioSimple iterador = primero;

            while (iterador.clave != clave) {
                iterador = iterador.sig;
            }
            iterador.valor = valor;
        } else {
            claves.Agregar(clave);

            NodoDiccionarioSimple nuevo = new NodoDiccionarioSimple();

            nuevo.clave = clave;
            nuevo.valor = valor;
            nuevo.sig = primero;

            primero = nuevo;
        }
    }

    public int Recuperar(int clave) {
        NodoDiccionarioSimple iterador = primero;

        while (iterador.clave != clave) {
            iterador = iterador.sig;
        }

        return (iterador.valor);
    }

    public void Eliminar(int clave) {
        if (primero.clave == clave) {
            primero = primero.sig;
        } else {
            NodoDiccionarioSimple iterador = primero;

            while (iterador.sig.clave != clave) {
                iterador = iterador.sig;
            }

            iterador.sig = iterador.sig.sig;
        }
        claves.Sacar(clave);
    }

    public ConjuntoTDA Claves() {
        return claves;
    }
}
