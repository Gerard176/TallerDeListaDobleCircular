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
    public Nodo buscar(String cancion){
        Nodo actual = cola;
        do {            
            if (actual.getCancion().equals(cancion)) {
                System.out.println("Cancion encontrada");
                return cancionEncontrada = actual;
            }else{
                System.out.println("No se encontro");
            }
            actual = actual.getSiguente();
            
        } while (actual.getSiguente() != cabeza);
      return null;  
    }
    
    public void reproducirEnAleatorio(boolean escancionSiguiente, String CancionReproduciendose){
        if (escancionSiguiente) {
            Nodo actual = buscar(CancionReproduciendose);
            System.out.println(actual.getCancion());
            
            int numeroAleatorio = (int) Math.round(Math.random()*15)+1;
            System.out.println(numeroAleatorio);
            
            for (int i = 0; i < numeroAleatorio; i++) {
                System.out.println("Pasando: "+actual.getCancion());
                actual = actual.getSiguente();
                cancionActual = actual.getCancion();
            }
        }
    }
    public void reproducirNormalmente(boolean escancionSiguiente, String CancionReproduciendose){
        if (escancionSiguiente) {
            Nodo actual = buscar(CancionReproduciendose);
            actual.getSiguente();
            cancionActual = actual.getCancion();
        }else{
            Nodo actual = buscar(CancionReproduciendose);
            actual.getAnterior();
            cancionActual = actual.getCancion();
            
        }
    }
    
}
