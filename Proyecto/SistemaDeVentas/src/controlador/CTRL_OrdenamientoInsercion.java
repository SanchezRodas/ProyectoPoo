/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;  // Importa List desde java.util
import modelo.Producto;



/**
 * Clase que contiene m�todos de ordenamiento por inserci�n.
 *
 * Esta clase proporciona m�todos para ordenar arreglos de enteros, arreglos de cadenas y listas de productos.
 */
public class CTRL_OrdenamientoInsercion {
    /**
     * Ordena un arreglo de enteros utilizando el algoritmo de ordenamiento por inserci�n.
     *
     * @param arr El arreglo de enteros que se va a ordenar.
     */
    public static void insercion(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Mover elementos del subarreglo ordenado que son mayores que la clave
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    /**
     * Ordena un arreglo de cadenas utilizando el algoritmo de ordenamiento por inserci�n.
     *
     * @param arr El arreglo de cadenas que se va a ordenar.
     */
    public static void insercion(String[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            String key = arr[i];
            int j = i - 1;

            // Mover elementos del subarreglo ordenado que son mayores en orden lexicogr�fico que la clave
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    /**
     * Ordena una lista de productos por precio utilizando el algoritmo de ordenamiento por inserci�n.
     *
     * @param productos La lista de productos que se va a ordenar.
     */
    public static void ordenamientoInsercionPrecio(List<Producto> productos) {
        int n = productos.size();
        for (int i = 1; i < n; i++) {
            Producto objetoActual = productos.get(i);
            double precioActual = objetoActual.getPrecio();

            int j = i - 1;
            while (j >= 0 && productos.get(j).getPrecio() > precioActual) {
                productos.set(j + 1, productos.get(j));
                j--;
            }
            productos.set(j + 1, objetoActual);
        }
    }
    public static void ordenamientoInsercionCodigo(List<Producto> productos) {
    int n = productos.size();
    for (int i = 1; i < n; i++) {
        Producto objetoActual = productos.get(i);
        int codigoActual = objetoActual.getIdProdcuto();

        int j = i - 1;
        while (j >= 0 && productos.get(j).getIdProdcuto()> codigoActual) {
            productos.set(j + 1, productos.get(j));
            j--;
        }
        productos.set(j + 1, objetoActual);
    }
}

}



