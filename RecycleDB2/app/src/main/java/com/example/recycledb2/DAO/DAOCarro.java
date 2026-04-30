package com.example.recycledb2.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.recycledb2.Entitys.Carro;

import java.util.List;

@Dao
public interface DAOCarro {

    @Insert
    void insertar(Carro carro);

    @Update
    void actualizar(Carro carro);

    @Delete
    void eliminar(Carro carro);

    @Query("SELECT * FROM Carro")
    List<Carro> obtenerTodos();

    @Query("SELECT * FROM Carro WHERE id = :id")
    Carro obtenerPorId(int id);
}