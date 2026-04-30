package com.example.recycledb1.Database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.recycledb1.DAO.DAOReceta;
import com.example.recycledb1.Entitys.Ingredientes;
import com.example.recycledb1.Entitys.Receta;

import javax.xml.validation.Schema;

@Database(entities = {Receta.class, Ingredientes.class}, version = 1, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase
{
        public abstract DAOReceta daoReceta();
}
