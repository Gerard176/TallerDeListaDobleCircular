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
            
           cola.setSiguente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
            
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
    
    public void imprimir(){
        Nodo tem = cabeza;
        do {            
            System.out.println(tem.getCancion());
            tem = tem.getSiguente();
        } while (tem!=null);
    }
    
    
}
