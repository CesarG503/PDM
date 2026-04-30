package com.example.recycledb2.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.recycledb2.Entitys.Inventario;

import java.util.List;

@Dao
public interface DAOInventario {

    @Insert
    void insertar(Inventario inventario);

    @Update
    void actualizar(Inventario inventario);

    @Delete
    void eliminar(Inventario inventario);

    @Query("SELECT * FROM Inventario")
    List<Inventario> obtenerTodos();

    @Query("SELECT * FROM Inventario WHERE id = :id")
    Inventario obtenerPorId(int id);
}