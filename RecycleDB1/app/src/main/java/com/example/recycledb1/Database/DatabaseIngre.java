package com.example.recycledb1.Database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.recycledb1.DAO.DAOIngrediente;
import com.example.recycledb1.Entitys.Ingrediente;

@Database(entities = {Ingrediente.class}, version = 1, exportSchema = false)
public abstract class DatabaseIngre extends RoomDatabase {
    public abstract DAOIngrediente daoIngrediente();

}
