package com.example.recycledb.entitys;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class Relacion {

    @Embedded
    public Receta receta;

    @Relation(
            parentColumn = "id",
            entityColumn = "id_receta"

    )
    public List<Ingrediente> ingredientes;

}
