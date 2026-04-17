package com.example.recycleview.migrations;

import androidx.annotation.Nullable;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class Migrations {

    public static final Migration MIGRATIONS_3_4 = new Migration(2,3)
    {
        @Override
        public void migrate(@Nullable SupportSQLiteDatabase connection)
        {
          super.migrate(connection);

          connection.execSQL("" + "");
        }
    };
}
