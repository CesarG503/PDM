package com.example.recycledb2.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.recycledb2.DAO.DAOProducto;
import com.example.recycledb2.Entitys.Producto;

@Database(entities = {Producto.class}, version = 1, exportSchema = false)
public abstract class db extends RoomDatabase {
    public abstract DAOProducto productoDao();
}