package api;

public interface ColaPrioridadTDA {
    int Primero();
    boolean ColaVacia();
    void Desacolar();
    void InicializarCola();
    void Acolar(int valor, int prioridad);
}
