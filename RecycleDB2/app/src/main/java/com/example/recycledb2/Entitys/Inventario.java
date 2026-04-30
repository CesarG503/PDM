package com.example.recycledb2.Entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Inventario")
public class Inventario {

    @PrimaryKey(autoGenerate = true)
    public int id;

}