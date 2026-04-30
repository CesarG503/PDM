package com.example.recycledb2.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.recycledb2.Entitys.Ingrediente;

import java.util.List;

@Dao
public interface DAOIngrediente {

    @Insert
    void insertar(Ingrediente ingrediente);

    @Update
    void actualizar(Ingrediente ingrediente);

    @Delete
    void eliminar(Ingrediente ingrediente);

    @Query("SELECT * FROM Ingrediente")
    List<Ingrediente> obtenerTodos();

    @Query("SELECT * FROM Ingrediente WHERE id = :id")
    Ingrediente obtenerPorId(int id);
}