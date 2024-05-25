package api;

public interface ListaPromediadaTDA {
    public void Inicializar();
    public void Agregar(int valor);
    public void Eliminar(int valor);
    public float Promedio();
    public ColaTDA Menores();
    public ColaTDA Mayores();
    public boolean EstaVacia();
}
