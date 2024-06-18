package api.TPO;

public interface ConjuntoCiudadTDA {
    void InicializarConjunto();
    boolean ConjuntoVacio();
    void Agregar(String ciudad );
    String Elegir();
    void Sacar(String Ciudad);
    boolean Pertenece(String Ciudad);
    void imprimir(ConjuntoCiudadTDA c1);
}
