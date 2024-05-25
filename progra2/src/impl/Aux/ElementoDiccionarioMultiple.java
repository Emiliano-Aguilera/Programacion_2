package impl.Aux;

import api.ConjuntoTDA;

public class ElementoDiccionarioMultiple {
    public int clave;
    public ConjuntoTDA valores;

    public void Inicializar() {
        valores.InicializarConjunto();
    }
}
