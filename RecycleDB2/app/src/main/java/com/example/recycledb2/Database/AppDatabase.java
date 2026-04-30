package com.example.recycledb2.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;

import com.example.recycledb2.DAO.DAOReceta;
import com.example.recycledb2.Entitys.Receta;

@Database(entities = {Receta.class}, version = 1, exportSchema = false)
public abstract class AppDatabase  extends RoomDatabase{
    public abstract DAOReceta daoReceta();
}
