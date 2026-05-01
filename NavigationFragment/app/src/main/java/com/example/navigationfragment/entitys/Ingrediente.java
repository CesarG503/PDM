package com.example.navigationfragment.entitys;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Ingrediente", foreignKeys = @ForeignKey(entity = Receta.class, parentColumns = "id", childColumns = "id_receta", onDelete = ForeignKey.CASCADE))
public class Ingrediente {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int id_receta;

    public String nombre;

    public int cantidad;
}
