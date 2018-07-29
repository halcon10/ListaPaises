package com.anevents.listapaises;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.Snackbar;
import android.widget.EditText;


public class Busqueda extends AppCompatActivity {

    RecyclerView recyclerView;
    AppDatabase db;

    RecyclerView.Adapter adapter;

    BusquedaDb dominicana;
    EditText palabra;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busqueda_paises);


        recyclerView = findViewById(R.id.recycler_viewbuscar);
        final Button button = findViewById(R.id.botonbuscar);
        palabra = findViewById(R.id.palabra);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        adapter = new BusquedaDbAdapter(db.busquedaDao().getAll());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

   //     dominicana = new BusquedaDb("Republica Dominicana");

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Snackbar.make(v, "Se agrego un nuevo registro al historico de busqueda", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


               BusquedaDb busquedaDb = new BusquedaDb(palabra.getText().toString());
               db.busquedaDao().insertAll(busquedaDb);

                startActivity(new Intent(Busqueda.this, MainActivity.class));
            }
        });

    }
}

