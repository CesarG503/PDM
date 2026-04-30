package com.example.recycledb2.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.recycledb2.Entitys.Producto;

import java.util.List;

@Dao
public interface DAOProducto {

    @Insert
    void insertar(Producto producto);

    @Update
    void actualizar(Producto producto);

    @Delete
    void eliminar(Producto producto);

    @Query("SELECT * FROM Producto")
    List<Producto> obtenerTodos();

    @Query("SELECT * FROM Producto WHERE id = :id")
    Producto obtenerPorId(int id);
}