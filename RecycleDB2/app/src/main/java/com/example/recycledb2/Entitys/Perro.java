package com.example.recycledb2.Entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Perro")
public class Perro {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nombre;
    public int edad;
    public boolean vacunas;
    public String dueño;

}