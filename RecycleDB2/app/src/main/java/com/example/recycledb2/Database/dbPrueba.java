package com.example.recycledb2.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.recycledb2.DAO.DAOPerro;
import com.example.recycledb2.Entitys.Perro;

@Database(entities = {Perro.class}, version = 1, exportSchema = false)
public abstract class dbPrueba extends RoomDatabase {

    public abstract DAOPerro perroDao();

}