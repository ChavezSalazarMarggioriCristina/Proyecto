package com.example.proyectoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioProducto {

    // Lista estática que actúa como almacenamiento en memoria
    private static final List<Producto> listaProductos = new ArrayList<>();

    // Método para agregar un producto
    public static void agregarProducto(Producto producto) {
        if (producto != null) {
            listaProductos.add(producto);
        }
    }

    // Método para obtener una copia inmutable de la lista de productos
    public static List<Producto> obtenerProductos() {
        return Collections.unmodifiableList(listaProductos);
    }

    // Método para eliminar un producto específico
    public static void eliminarProducto(Producto producto) {
        listaProductos.remove(producto);
    }

    // Método para limpiar toda la lista (por ejemplo, al cerrar sesión)
    public static void limpiar() {
        listaProductos.clear();
    }
}
