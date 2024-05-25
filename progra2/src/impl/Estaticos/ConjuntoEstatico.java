package impl.Estaticos;

import api.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA {
    public int[] valores;
    public int indice;

    public void InicializarConjunto() {
        valores = new int[100];
        indice = 0;
    }

    public boolean ConjuntoVacio() {
        return (indice == 0);
    }

    public void Agregar(int elemento) {
        if (!Pertenece(elemento)) {
            valores[indice] = elemento;
            indice++;
        }
    }

    public void Sacar(int elemento) {
        int indiceElemento = BuscarElemento(elemento);
        if (indiceElemento != -1) {
            valores[indiceElemento] = valores[indice--];
        }
    }

    public boolean Pertenece(int elemento) {
        return (BuscarElemento(elemento) != -1);
    }

    public int Elegir() {
        if (indice > 1) {
            return (valores[Math.abs((int) System.currentTimeMillis() % (indice - 1))]);
        } else {
            return (valores[indice]);
        }
    }

    private int BuscarElemento(int elemento) {
        for (int i = 0; i < indice; i++) {
            if (valores[i] == elemento) {
                return (i);
            }
        }
        return -1;
    }

    public void MostrarConjunto(){
        for (int i = 0; i < indice; i++) {
            System.out.println(valores[i]);
        }
    }
}
