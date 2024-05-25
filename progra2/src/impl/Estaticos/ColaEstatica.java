package impl.Estaticos;

import api.ColaTDA;

public class ColaEstatica implements ColaTDA {
    int[] valores;
    int ultimo;

    public void InicializarCola() {
        valores = new int[100];
        ultimo = 0;
    }

    public void Acolar(int x) {
        valores[ultimo] = x;
        ultimo++;
    }

    public void Desacolar() {
        for (int i = 0; i < ultimo - 1; i++) {
            valores[i] = valores[i + 1];
        }

        ultimo--;
    }

    public int Primero() {
        return (valores[0]);
    }

    public boolean ColaVacia() {
        return (ultimo == 0);
    }
}