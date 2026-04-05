package com.example.recycleview.models;

public class Producto {


    public String nombre;
    public int stock;

    public int image;

    public Producto(String nombre, int image, int stock) {
        this.nombre = nombre;
        this.image = image;
        this.stock = stock;
    }
    public Producto() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
