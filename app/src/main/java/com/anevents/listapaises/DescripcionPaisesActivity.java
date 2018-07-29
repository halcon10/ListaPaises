package com.anevents.listapaises;


import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.text.method.ScrollingMovementMethod;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DescripcionPaisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_paises);

        getSupportActionBar().hide();

        String nomb = getIntent().getExtras().getString("nombre");
        String desc = getIntent().getExtras().getString("descripcion");
        String cat = getIntent().getExtras().getString("capital");
        String est = getIntent().getExtras().getString("poblacion");
        String img = getIntent().getExtras().getString("imagen");


        TextView tv_nombre = findViewById(R.id.b_nombre);
        TextView tv_descripcion = findViewById(R.id.b_area);
        TextView tv_capital = findViewById(R.id.b_capital);
        TextView tv_poblacion = findViewById(R.id.b_poblacion);
        AppCompatImageView tv_imagen = findViewById(R.id.b_bandera);


        tv_nombre.setText(nomb);
        tv_descripcion.setText(desc);
        tv_capital.setText(cat);
        tv_poblacion.setText(est);

        tv_descripcion.setMovementMethod(new ScrollingMovementMethod());

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        Glide.with(this).load(img).into(tv_imagen);
    }
}
