package api.TPO;

public interface GrafoCiudadTDA {
    void InicializarGrafo();
    void AgregarVertice(String ciudad,String provincia);
    void EliminarVertice(String ciudad,String provincia);
    ConjuntoCiudadTDA Vertices();
    ConjuntoCiudadTDA VerticesProvincia();
    void AgregarArista(String ciudad1, String ciudad2, int kilometros);
    void EliminarArista(String ciudad1,  String ciudad2);
    boolean ExisteArista(String ciudad1, String ciudad2);
    int PesoArista(String ciudad1, String ciudad2);
    


    
}
