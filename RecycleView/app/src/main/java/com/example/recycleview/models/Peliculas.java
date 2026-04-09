package com.example.recycleview.models;

public class Peliculas {
    private String nombre;
    private int sala;
    private double consto;
    private int asientos;
    private int img;

    public Peliculas(String nombre, int asientos, double consto, int sala, int img) {
        this.nombre = nombre;
        this.asientos = asientos;
        this.consto = consto;
        this.sala = sala;
        this.img   = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getConsto() {
        return consto;
    }

    public void setConsto(double consto) {
        this.consto = consto;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }
}
