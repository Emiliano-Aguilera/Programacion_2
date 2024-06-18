package impl.TPO;

import api.TPO.ConjuntoCiudadTDA;

public class ConjuntoCiudadDinamico implements ConjuntoCiudadTDA{

    class nodoCiudad{
        String Ciudad;
        nodoCiudad sig;
    }
    nodoCiudad primero;
    int cantidad = 0;
    
    public void InicializarConjunto() {
        primero = null;
    }

    
    public boolean ConjuntoVacio() {
        return primero == null;
    }

    
    public void Agregar(String ciudad) {
        nodoCiudad aux = new nodoCiudad();
        aux.Ciudad = ciudad;
        aux.sig = null;
        if( primero == null){
            primero = aux;
            cantidad++;
        }
        if(!Pertenece(ciudad)){
            aux.sig = primero;
            primero = aux;
            cantidad++;
        }
    }

    
    public String Elegir() {
        int numero =Math.abs((int) System.currentTimeMillis() % cantidad);
        nodoCiudad aux = primero;
    
        int i = 0;
        while(i < numero){
            aux = aux.sig;
            i++;

        }
        return aux.Ciudad;
    }

    
    public void Sacar(String Ciudad) {
        nodoCiudad aux = primero;
        if(primero.Ciudad == Ciudad){
            primero = primero.sig;
            cantidad--;
        }else{
            while(aux.sig.Ciudad != Ciudad){
                aux = aux.sig;

            }
            aux.sig = aux.sig.sig;
            cantidad--;
        }
    }

    
    public boolean Pertenece(String Ciudad) {
        nodoCiudad aux = primero;
        boolean pollito = false;
        while(!pollito && aux != null){
            if(aux.Ciudad == Ciudad){
                pollito = true;
            }else{
                aux = aux.sig;
            }
            

        }
        return pollito;
    }

    
    public void imprimir(ConjuntoCiudadTDA c1) {
        while (!c1.ConjuntoVacio()) {
            String elemento = c1.Elegir();
            System.out.println(elemento);
            c1.Sacar(elemento);
        }
    }

}
