package com.example.recycledb.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.recycledb.entitys.Ingrediente;

import java.util.List;

@Dao
public interface DAOingrediente {

    @Insert
    void insert(Ingrediente ingrediente);

    @Update
    void update(Ingrediente ingrediente);

    @Delete
    void delete(Ingrediente ingrediente);

    @Query("SELECT * FROM Ingrediente")
    List<Ingrediente> selectAll();

    @Query("SELECT * FROM Ingrediente WHERE id = :id")
    Ingrediente select(int id);

    @Query("SELECT * FROM Ingrediente WHERE id_receta = :id")
    List<Ingrediente> selectRecetaIngredientes(int id);
}
