package com.example.proyectoo;

public class ListaCompra
{
    private String nombre;
    private String descripcion;

    public ListaCompra(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
