package com.example.multiple;

public class Departamento {

    private String codigo;
    private String nombreDepartamento;

    public Departamento(String codigo, String nombreDepartamento) {
        this.codigo = codigo;
        this.nombreDepartamento = nombreDepartamento;
    }

    public Departamento()
    {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    @Override
    public String toString() {
        return nombreDepartamento ;
    }
}
