package com.example.recycleview.DAOS;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.recycleview.Entitys.Cliente;
import com.example.recycleview.Entitys.Factura;
import com.example.recycleview.Entitys.Relations.ClienteFactura;

import java.util.List;

@Dao
public interface facturaDAO{



    @Insert
    long insertCliente(Cliente cliente);

    @Insert

    long insertFactura(Factura factura);

    @Query("SELECT * FROM clientes")
    List<Cliente> getClientes();


    @Query("SELECT * FROM factura")
    List<Factura> getFactura();


    @Transaction
    @Query("SELECT * FROM clientes")
    List<ClienteFactura> getClientesFactura();


    @Update
    int updateCliente(Cliente cliente);

    @Query("UPDATE clientes SET nombreCliente=:nombre WHERE idCliente=:idcliente ")
    int updateNombreCliente(String nombre, int idcliente);


    @Delete
    int deleteCliente(Cliente cliente);

    @Query("DELETE FROM clientes WHERE idCliente=:idcliente")
    int deleteClienteID(int idcliente);
























}
