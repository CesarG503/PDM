package com.example.recycledb2.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.recycledb2.Entitys.Receta;

import java.util.List;

@Dao
public interface DAOReceta {

    @Insert
    void insert(Receta receta);

    @Delete
    void delete(Receta receta);

    @Update
    void update(Receta receta);


    @Query("SELECT * FROM Receta")
    List<Receta> selectAll();

    @Query("SELECT * FROM Receta WHERE id=:id")
    Receta select(int id);


}
