package com.example.recycledb.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.recycledb.entitys.Receta;

import java.util.List;
@Dao
public interface DAO {

    @Insert
    long  insertReceta(Receta receta);

    @Delete
    void deleteReceta(Receta receta);

    @Update
    void updateReceta(Receta receta);

    @Query("SELECT * FROM Receta")
    List<Receta> selectAllReceta();

    @Query("SELECT * FROM Receta WHERE id=:id")
    Receta selectReceta(int id);




}
