package com.example.recycleview.Entitys.Relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.recycleview.Entitys.Cliente;
import com.example.recycleview.Entitys.Factura;

import java.util.List;

public class ClienteFactura {

    @Embedded
    public Cliente cliente;

    @Relation(parentColumn = "idCliente", entityColumn = "idCliente")
    public List<Factura> facturas;





}
