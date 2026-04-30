package com.example.recycledb.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.recycledb.DAO.DAO;
import com.example.recycledb.DAO.DAOingrediente;
import com.example.recycledb.entitys.Ingrediente;
import com.example.recycledb.entitys.Receta;

@Database(entities = {Receta.class, Ingrediente.class}, version = 1,exportSchema = true)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract DAO recetaDao();
    public abstract DAOingrediente ingredienteDao();
}
