package com.example.recycledb2.Entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Camisa")
public class Camisa {

    @PrimaryKey(autoGenerate = true)
    public int id;

}