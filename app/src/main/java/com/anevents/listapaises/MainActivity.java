package com.anevents.listapaises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.View;
import android.support.design.widget.FloatingActionButton;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import android.content.Intent;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import android.support.design.widget.Snackbar;

public final class MainActivity extends AppCompatActivity {

    private final String Json_url = "https://hmasolutions.000webhostapp.com/Api.php?pais=";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Paises> ListaPaises;
    private RecyclerView recyclerView;


    /* //codigo de ejemplo para mostrar mensajes

            Snackbar.make(view, "Mensaje de prueba", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    });
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Busqueda.class));
            }
        });

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        ListaPaises = new ArrayList<Paises>();

        recyclerView = findViewById(R.id.recyclerView);
        JsonRequest();
    }

    private void JsonRequest(){

        request = new JsonArrayRequest(Json_url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for(int i=0; i<response.length(); i++){

                    try {
                        jsonObject = response.getJSONObject(i);
                        Paises paises = new Paises();

                        paises.setNombre(jsonObject.getString("pais"));
                        paises.setDescripcion(jsonObject.getString("area"));
                        paises.setCapital(jsonObject.getString("capital"));
                        paises.setPoblacion(jsonObject.getString("poblacion"));
                        paises.setImagen(jsonObject.getString("bandera"));

                        ListaPaises.add(paises);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                setRecyclerView(ListaPaises);

            }
        },new  Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setRecyclerView(List<Paises> listaPaises) {

        PaisesViewAdapter ViewAdapter = new PaisesViewAdapter(this,ListaPaises);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(ViewAdapter);
    }



}
