package com.example.imcviewholder.models;

public class Comida {

    private String nombre;
    private String categoria;
    private double precio;

    private int cantidad;

    private  boolean visible = false;

    public boolean isVisible() {
        return visible;
    }

    @Override
    public String toString() {
        if (cantidad >0) {
            return "producto: " + nombre + " precio: $" + precio + " cantidad: " + cantidad + "TOTAL: $" + (precio * cantidad);
        }
        else
        {
            return null;
        }
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Comida(String nombre, String categoria, double precio) {
        this.nombre = nombre;
        this.cantidad = 0;
        this.precio = precio;
        this.categoria = categoria;
    }
    public Comida(String nombre, String categoria, double precio, int cantidad ) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
