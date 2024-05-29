package api; //se especifica el paquete, que coincide con el nombre de la carpeta en la que esta el archivo

public interface PilaTDA {
    int Tope();
    boolean PilaVacia();
    void Desapilar();
    void Apilar(int x);
    void InicializarPila();
}
