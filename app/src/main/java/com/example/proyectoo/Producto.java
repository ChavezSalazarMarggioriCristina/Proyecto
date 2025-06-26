package com.example.proyectoo;

public class Producto {
    private String nombre;
    private String categoria;
    private boolean comprado;
    private double precio;
    private int cantidad;

    public Producto(String nombre, String categoria, boolean comprado) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.comprado = comprado;
        this.precio = 0;
        this.cantidad = 1;
    }

    public Producto(String nombre, String categoria, boolean comprado, double precio, int cantidad) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.comprado = comprado;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isComprado() {
        return comprado;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
