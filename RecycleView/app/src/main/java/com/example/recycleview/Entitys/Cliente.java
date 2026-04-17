package com.example.recycleview.Entitys;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "clientes")
public class Cliente {

    @PrimaryKey(autoGenerate = true)
    public int idCliente;

    @ColumnInfo(name = "nombreCliente")
    public String nombreCliente;

    // version nueva de la tabla

    public String correo;

    @Nullable
    public Integer edad;

    public String direccion;

}
