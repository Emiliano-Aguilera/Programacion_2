package impl.Estaticos;

import api.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {
    int indice;
    int[] valores;
    int[] prioridades;

    public void InicializarCola() {
        indice = 0;
        valores = new int[100];
        prioridades = new int[100];
    }

    public void Acolar(int valor, int prioridad) {
        int i = 0;

        while (prioridad > prioridades[i] && i < indice) {
            i++;
        }

        Insertar(i, indice, valor, prioridad);
    }

    public void Desacolar() {
        indice--;
    }

    public int Primero() {
        return (valores[indice - 1]);
    }

    public boolean ColaVacia() {
        return (indice == 0);
    }

    public int Prioridad(){
        return(prioridades[0]);
    }

    private void Insertar(int inicio, int fin, int valor_, int prioridad_) {
        for (int i = fin; i > inicio; i--) {
            valores[i] = valores[i - 1];
            prioridades[i] = prioridades[i - 1];
        }

        valores[inicio] = valor_;
        prioridades[inicio] = prioridad_;
        indice++;
    }
}
