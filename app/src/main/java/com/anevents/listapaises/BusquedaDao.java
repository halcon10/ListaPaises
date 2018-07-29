package com.anevents.listapaises;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;


@Dao
public interface BusquedaDao {

    @Query("SELECT * FROM busquedadb")
    List<BusquedaDb> getAll();

    @Insert
    void insertAll(BusquedaDb... busquedaDb);
}