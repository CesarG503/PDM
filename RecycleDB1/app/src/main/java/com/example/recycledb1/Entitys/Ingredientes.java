package com.example.recycledb1.Entitys;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Ingredientes", foreignKeys = @ForeignKey(entity = Receta.class,parentColumns ="id", childColumns = "id_receta",onDelete = 1))
public class Ingredientes {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public int id_receta;
    public String nombre_ingrediente;
    public int cantidad;
}
