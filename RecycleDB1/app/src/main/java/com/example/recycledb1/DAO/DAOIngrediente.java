package com.example.recycledb1.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.recycledb1.Entitys.Ingrediente;

import java.util.List;

@Dao
public interface DAOIngrediente {

    @Insert
    void insert(Ingrediente ingrediente);

    @Delete
    void delete(Ingrediente ingrediente);

    @Update
    void update(Ingrediente ingrediente);

    @Query("SELECT * FROM Ingrediente")
    List<Ingrediente> selecAll();

    @Query("SELECT * FROM Ingrediente WHERE id=:id")
    Ingrediente select(int id);

}
