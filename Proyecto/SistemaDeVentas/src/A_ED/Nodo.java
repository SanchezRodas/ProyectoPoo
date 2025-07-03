/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A_ED;

import modelo.Producto;

/**
 *
 * @author USUARIO
 */
public class Nodo {
      private Producto valor;

    // Referencia al siguiente nodo en la lista
    private Nodo siguiente;

    // Constructor para crear un nodo con un valor dado (de tipo Producto)
    public Nodo(Producto valor) {
        this.valor = valor;
        this.siguiente = null; // Inicialmente, no hay siguiente nodo
    }

    // M�todos Getter y Setter para el valor del nodo
    public Producto getValor() {
        return valor;
    }

    public void setValor(Producto valor) {
        this.valor = valor;
    }

    // M�todo Getter para el siguiente nodo
    public Nodo getSiguiente() {
        return siguiente;
    }

    // M�todo Setter para establecer el siguiente nodo
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
