package com.example.recycledb2.Entitys;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Receta.class, parentColumns = "id", childColumns = "id_receta", onDelete = ForeignKey.CASCADE))
public class Pago {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int id_receta;
}