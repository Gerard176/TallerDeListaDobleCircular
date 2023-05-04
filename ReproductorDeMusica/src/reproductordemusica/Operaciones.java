/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductordemusica;

/**
 *
 * @author MAELDUSA
 */
public class Operaciones {
    
    Nodo cabeza;
    Nodo cola;
    Nodo cancionEncontrada;
    String cancionActual;
    
    
    
    public void add(String cancion){
        Nodo nuevo = new Nodo();
        nuevo.setCancion(cancion);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            
        }else{
            
            nuevo.setSiguente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
            
        }
    
    }
    public Nodo buscar(String cancion){
        Nodo actual = cola;
        do {            
            if (actual.getCancion().equals(cancion)) {
                System.out.println("Cancion encontrada");
                return cancionEncontrada = actual;
                
            }
            System.out.println(actual.getCancion());
            actual = actual.getSiguente();
            
        } while (actual != cabeza);
      return null;  
    }
    
   
    public void reproducirNormalmente(boolean escancionSiguiente, String CancionReproduciendose){
        if (escancionSiguiente) {
            Nodo actual = buscar(CancionReproduciendose);
            
            actual = actual.getSiguente();
            System.out.println(actual.getCancion());
            cancionActual = actual.getCancion();
        }else{
            Nodo actual = buscar(CancionReproduciendose);
            actual = actual.getAnterior();
            System.out.println(actual.getCancion());
            cancionActual = actual.getCancion();
            
        }
    }
    
}
