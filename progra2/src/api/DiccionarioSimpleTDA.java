package api;

public interface DiccionarioSimpleTDA {
    int Recuperar(int clave);
    void Eliminar(int clave);
    void InicializarDiccionario();
    void Agregar(int clave, int valor);
    ConjuntoTDA Claves();
}
