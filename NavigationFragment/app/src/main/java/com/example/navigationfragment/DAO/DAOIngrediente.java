package com.example.navigationfragment.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.navigationfragment.entitys.Ingrediente;

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

    @Query("SELECT * FROM Ingrediente WHERE id_receta = :id")
    List<Ingrediente> obtenerPorIdReceta(int id);
}