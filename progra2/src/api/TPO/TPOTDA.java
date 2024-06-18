package api.TPO;

public interface TPOTDA {
    void inicializar();
    ConjuntoCiudadTDA listarProvincias();
    ConjuntoCiudadTDA listarCiudades();
    void cargarCiudad(String ciudad, String provincia);
    void eliminarCiudad(String ciudad, String provincia);
    void AniadirRuta(String ciudad1, String ciudad2, int Kilometros);
    ConjuntoCiudadTDA ciudadesVecinas(String ciudad);
    ConjuntoCiudadTDA ciudadesPuente(String ciudadA, String ciudadB);
    ConjuntoCiudadTDA ciudadesPredecesoras(String ciudadA);
    ConjuntoCiudadTDA ciudadesExtremo();
    void listarCiudadesFuertementeConectadas();
    String calcularCamino(String ciudadA, String ciudadB);
    void CargarCiudadesPrueba();

}
