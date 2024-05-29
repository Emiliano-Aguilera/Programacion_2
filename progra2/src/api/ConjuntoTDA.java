package api;

public interface ConjuntoTDA {
    int Elegir();
    boolean ConjuntoVacio();
    boolean Pertenece(int elemento);
    void Sacar(int elemento);
    void Agregar(int elemento);
    void InicializarConjunto();
    void MostrarConjunto();
}
