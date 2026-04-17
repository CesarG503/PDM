package com.example.recycleview.Entitys;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "factura", foreignKeys = @ForeignKey(entity = Cliente.class, parentColumns = "idCliente", childColumns = "idCliente", onDelete = ForeignKey.RESTRICT))
// parent colum es el nombre de la columna padre origen, el childcolumns es el nombre de la tabla hijo la actual
public class Factura {

    @PrimaryKey(autoGenerate = true)
    public int idFactura;

    @ColumnInfo(name = "fecha")
    public String fecha;
    public int idCliente;
}
