package api;

public interface HeapTDA {
    void inicializarHeap(); // Inicializa el heap
    void agregarElemento(int x); // Agrega un elemento al heap
    void eliminarCima(); // Elimina el elemento en la cima del heap
    int obtenerCima(); // Obtiene el elemento en la cima del heap
    boolean heapVacio(); // Verifica si el heap está vacío
}
