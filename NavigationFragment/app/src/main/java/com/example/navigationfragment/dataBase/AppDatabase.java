package com.example.navigationfragment.dataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.navigationfragment.DAO.DAOIngrediente;
import com.example.navigationfragment.DAO.DAOReceta;
import com.example.navigationfragment.entitys.Ingrediente;
import com.example.navigationfragment.entitys.Receta;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Receta.class, Ingrediente.class},  version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DAOReceta daoReceta();
    public abstract DAOIngrediente daoIngrediente();

    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);
    private static volatile AppDatabase INSTANCE;
    public static AppDatabase getINSTANCE(Context context){
        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                    "db_prestamos"
                            )
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
