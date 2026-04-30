package com.example.recycledb2.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.recycledb2.Entitys.Perro;

import java.util.List;

@Dao
public interface DAOPerro {

    @Insert
    void insertar(Perro perro);

    @Update
    void actualizar(Perro perro);

    @Delete
    void eliminar(Perro perro);

    @Query("SELECT * FROM Perro")
    List<Perro> obtenerTodos();

    @Query("SELECT * FROM Perro WHERE id = :id")
    Perro obtenerPorId(int id);
}