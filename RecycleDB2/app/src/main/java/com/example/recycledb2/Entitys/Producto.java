package com.example.recycledb2.Entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Producto")
public class Producto {

    @PrimaryKey(autoGenerate = true)
    public int id;

}