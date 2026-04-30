package com.example.recycledb1.Entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Ingrediente")
public class Ingrediente {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nombre_ingrediente;
    public int cantidad;
}
