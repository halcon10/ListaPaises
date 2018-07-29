package com.anevents.listapaises;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = BusquedaDb.class, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BusquedaDao busquedaDao();
}
