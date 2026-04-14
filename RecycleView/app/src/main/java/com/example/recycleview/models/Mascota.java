package com.example.recycleview.models;

public class Mascota {

    private String NombrePerro;
    private int edadPerro;

    private double alturaPerro;

    private int img;

    public Mascota(String nombrePerro, int edadPerro, int img, double alturaPerro) {
        NombrePerro = nombrePerro;
        this.edadPerro = edadPerro;
        this.img = img;
        this.alturaPerro = alturaPerro;
    }

    public String getNombrePerro() {
        return NombrePerro;
    }

    public void setNombrePerro(String nombrePerro) {
        NombrePerro = nombrePerro;
    }

    public int getEdadPerro() {
        return edadPerro;
    }

    public void setEdadPerro(int edadPerro) {
        this.edadPerro = edadPerro;
    }

    public double getAlturaPerro() {
        return alturaPerro;
    }

    public void setAlturaPerro(double alturaPerro) {
        this.alturaPerro = alturaPerro;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return NombrePerro;
    }
}
