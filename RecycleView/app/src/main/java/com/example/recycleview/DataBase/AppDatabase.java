package com.example.recycleview.DataBase;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.recycleview.DAOS.facturaDAO;
import com.example.recycleview.Entitys.Cliente;
import com.example.recycleview.Entitys.Factura;

@Database(entities = {Cliente.class, Factura.class}, version = 2, exportSchema = true, autoMigrations = {@AutoMigration(from =1, to = 2 )}) //para hacer migraciones automaticas si queremos cambiar la version
public abstract class AppDatabase extends RoomDatabase {

    public abstract facturaDAO daoFacturas();

}
