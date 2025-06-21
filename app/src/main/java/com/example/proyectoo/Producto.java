package com.example.proyectoo;

public class Producto {
    private String nombre;
    private String categoria;
    private boolean comprado;

    public Producto(String nombre, String categoria, boolean comprado) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.comprado = comprado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }
}

