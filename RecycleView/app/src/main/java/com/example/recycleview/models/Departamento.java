package com.example.recycleview.models;

public class Departamento {

    private String NombreDep;
    private int NumeroDep;
    private double KilometrosDep;


    public Departamento(String nombreDep, double kilometrosDep, int numeroDep) {
        NombreDep = nombreDep;
        KilometrosDep = kilometrosDep;
        NumeroDep = numeroDep;
    }

    public String getNombreDep() {
        return NombreDep;
    }

    public void setNombreDep(String nombreDep) {
        NombreDep = nombreDep;
    }

    public double getKilometrosDep() {
        return KilometrosDep;
    }

    public void setKilometrosDep(double kilometrosDep) {
        KilometrosDep = kilometrosDep;
    }

    public int getNumeroDep() {
        return NumeroDep;
    }

    public void setNumeroDep(int numeroDep) {
        NumeroDep = numeroDep;
    }
}
