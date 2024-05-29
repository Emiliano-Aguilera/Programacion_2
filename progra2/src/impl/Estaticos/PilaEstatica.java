package impl.Estaticos;

import api.PilaTDA;

public class PilaEstatica implements PilaTDA {

    int[] valores;
    int i;

    public void InicializarPila() {
        valores = new int[100];
        i = 0;
    }

    public void Apilar(int x) {
        valores[i] = x;
        i++;
    }

    public void Desapilar() {
        i--;
    }

    public int Tope() {
        return (valores[i - 1]);
    }

    public boolean PilaVacia() {
        return (i == 0);
    }
}
