/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import A_ED.Nodo;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

/**
 *
 * @author Josue
 */
public class ListaEnlazada {

    Nodo nodoInicial; // Primer nodo de la lista
    int numElementos; // N�mero de elementos en la lista

    // Constructor para crear una lista enlazada vac�a
    public ListaEnlazada() {
        nodoInicial = null; // Inicialmente, no hay nodos
        numElementos = 0;  // Inicialmente, el contador es 0
    }

    public int size() {
        return numElementos;
    }

    // M�todo para agregar un nuevo nodo al final de la lista
    public void agregarNodo(Producto producto) {
        Nodo nuevoNodo = new Nodo(producto);

        // Si la lista est� vac�a, el nuevo nodo se convierte en el nodo inicial
        if (nodoInicial == null) {
            nodoInicial = nuevoNodo;
        } else {
            // Si la lista no est� vac�a, recorremos la lista hasta llegar al �ltimo nodo
            Nodo nodoActual = nodoInicial;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }

            // Enlazamos el �ltimo nodo con el nuevo nodo
            nodoActual.setSiguiente(nuevoNodo);
        }

        numElementos++; // Incrementamos el contador de elementos
    }

    // M�todo para imprimir los elementos de la lista
    public void imprimir() {
        Nodo nodoActual = nodoInicial;

        System.out.println("Elementos de la lista enlazada:");

        while (nodoActual != null) {
            System.out.println("ID: " + nodoActual.getValor().getIdProdcuto());
            System.out.println("Descripcion: " + nodoActual.getValor().getDescripcion());
            System.out.println("Precio: " + nodoActual.getValor().getPrecio());
            System.out.println();

            nodoActual = nodoActual.getSiguiente();
        }
    }

    public boolean remover(int codigo) {
        if (nodoInicial == null) {
            // La lista est� vac�a, no hay elementos para eliminar
            return false;
        }

        if (nodoInicial.getValor().getIdProdcuto() == codigo) {
            // El primer nodo contiene el producto a eliminar
            nodoInicial = nodoInicial.getSiguiente();
            numElementos--;
            return true;
        }

        Nodo nodoActual = nodoInicial;
        while (nodoActual.getSiguiente() != null) {
            if (nodoActual.getSiguiente().getValor().getIdProdcuto() == codigo) {
                // El siguiente nodo contiene el producto a eliminar
                nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente());
                numElementos--;
                return true;
            }
            nodoActual = nodoActual.getSiguiente();
        }

        // No se encontr� el producto con el c�digo especificado
        return false;
    }

    public Producto buscar(int codigo) {
        Nodo nodoActual = nodoInicial;

        while (nodoActual != null) {
            if (nodoActual.getValor().getIdProdcuto() == codigo) {
                // Se encontr� el producto con el c�digo especificado
                return nodoActual.getValor();
            }
            nodoActual = nodoActual.getSiguiente();
        }

        // No se encontr� el producto con el c�digo especificado
        return null;
    }

    public List<Producto> toList() {
        List<Producto> productList = new ArrayList<>();
        Nodo nodoActual = nodoInicial;

        while (nodoActual != null) {
            productList.add(nodoActual.getValor());
            nodoActual = nodoActual.getSiguiente();
        }

        return productList;
    }

    public void vaciar() {
        nodoInicial = null; // Establece el primer nodo como nulo para vaciar la lista
        numElementos = 0;
    }

}
