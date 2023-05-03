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
    String cancionEncontrada;
    
    public void add(String cancion){
        Nodo nuevo = new Nodo();
        nuevo.setCancion(cancion);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            cabeza.setSiguente(cola);
            cola.setSiguente(cabeza);
        }else{
            
            cabeza.setSiguente(nuevo);
            nuevo.setAnterior(cabeza);
            cola.setAnterior(nuevo);
            nuevo.setSiguente(cola);
            cabeza = nuevo;
            
        }
    
    }
    public void buscar(String cancion){
        Nodo actual = cola;
        do {            
            if (actual.getCancion().equals(cancion)) {
                System.out.println("Cancion encontrada");
                cancionEncontrada = actual.getCancion();
            }
            actual = actual.getSiguente();
            
        } while (actual.getSiguente() != cabeza);
        
    }
    public void reproducirEnAleatorio(boolean cancionSiguiente){
        
    }
    public void reproducirNormalmente(boolean cancionSiguiente){
        
    }
    
}
