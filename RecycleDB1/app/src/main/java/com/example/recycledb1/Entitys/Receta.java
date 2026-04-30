package com.example.recycledb1.Entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Receta")
public class Receta {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nombre;
    public String descripcion;
    public int servicios;
}
