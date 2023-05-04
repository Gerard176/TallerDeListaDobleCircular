/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductordemusica;

/**
 *
 * @author MAELDUSA
 */
public class Nodo {
    private String cancion;
    private Nodo siguente;
    private Nodo Anterior;

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public Nodo getSiguente() {
        return siguente;
    }

    public void setSiguente(Nodo siguente) {
        this.siguente = siguente;
    }

    public Nodo getAnterior() {
        return Anterior;
    }

    public void setAnterior(Nodo Anterior) {
        this.Anterior = Anterior;
    }

    void setSiguiente(Nodo cabeza) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
