package com.example.imcviewholder.models;

public class Persona {

    private String nombre;
    private int edad;
    private String genero;

    private double altura;
    private double peso;
    private double IMC;
    private String categoria;

    public Persona(double peso, double altura, String genero, int edad, String nombre) {
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
        this.edad = edad;
        this.nombre = nombre;
    }

    public void calcular_IMC(double peso, double altura)
    {
        this.IMC = peso / altura ;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }
}
