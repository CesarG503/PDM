package com.example.recycledb2.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.recycledb2.DAO.DAOCarro;
import com.example.recycledb2.Entitys.Carro;

@Database(entities = {Carro.class}, version = 1, exportSchema = false)
public abstract class AppDatabaseNew extends RoomDatabase {

    public abstract DAOCarro Dao();

}