package com.example.recycledb2.Entitys;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Ingrediente", foreignKeys = @ForeignKey(entity = Receta.class,parentColumns = "id",childColumns = "id_receta",onDelete = 1))
public class Ingrediente {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public int id_receta;
    public String nombre;
    public int cantidad;

}
