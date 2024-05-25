package impl.Aux;

import api.ConjuntoTDA;
import impl.Dinamicos.ConjuntoDinamico;

public class NodoDiccionarioMultiple {
    public int clave;
    public ConjuntoTDA valores;
    public NodoDiccionarioMultiple sig;
    
    public void InicializarNodo(){
        valores = new ConjuntoDinamico();
        valores.InicializarConjunto();
    }
}
