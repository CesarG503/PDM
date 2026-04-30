package com.example.navigationfragment.entitys;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Receta")
public class Receta {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nombre_receta;

    public String descripcion_receta;

    public int servicios;
}
