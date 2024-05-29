package impl.Aux;

import api.ConjuntoTDA;
import impl.Estaticos.ConjuntoEstatico;

public class ElementoDiccionarioMultiple {
    public int clave;
    public ConjuntoTDA valores;

    public void Inicializar() {
        valores = new ConjuntoEstatico();
        valores.InicializarConjunto();
    }
}
