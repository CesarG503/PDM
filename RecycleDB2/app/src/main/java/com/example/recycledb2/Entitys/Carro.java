package com.example.recycledb2.Entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Carro")
public class Carro {

    @PrimaryKey(autoGenerate = true)
    public int id;

}