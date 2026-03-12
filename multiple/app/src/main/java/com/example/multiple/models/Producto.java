package com.example.multiple.models;

public class Producto
{
    private int Imagen;
    private String Nombre_producto;

    private double precio;

    private boolean isSeleccionado;

    public Producto() {
    }

    public Producto(int imagen, double precio, String nombre_producto) {
        Imagen = imagen;
        this.precio = precio;
        Nombre_producto = nombre_producto;
    }

    public Producto(int imagen, String nombre_producto, double precio, boolean isSeleccionado) {
        Imagen = imagen;
        Nombre_producto = nombre_producto;
        this.precio = precio;
        this.isSeleccionado = isSeleccionado;
    }

    public boolean isSeleccionado() {
        return isSeleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        isSeleccionado = seleccionado;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre_producto() {
        return Nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        Nombre_producto = nombre_producto;
    }

    @Override
    public String toString() {
        return Nombre_producto;
        //return  "Imagen: " + Imagen + ", Nombre_producto: " + Nombre_producto + ", precio: " + precio ;
    }
}
