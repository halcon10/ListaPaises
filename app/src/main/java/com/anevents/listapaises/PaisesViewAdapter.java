package com.anevents.listapaises;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.anevents.listapaises.R;

public class PaisesViewAdapter extends RecyclerView.Adapter<PaisesViewAdapter.paisesViewHolder> {

    private Context mContext;
    private List<Paises> Datos;
    RequestOptions option;

    public PaisesViewAdapter(Context mContext, List<Paises> datos) {
        this.mContext = mContext;
        Datos = datos;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }


    @Override
    public paisesViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view;

        LayoutInflater infla = LayoutInflater.from(mContext);
        view = infla.inflate(R.layout.paises_list_item,parent,false);

        final paisesViewHolder paises = new paisesViewHolder(view);
        paises.contenedorPaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, DescripcionPaisesActivity.class);

                intent.putExtra("name",Datos.get(paises.getAdapterPosition()).getNombre());
                intent.putExtra("descripcion",Datos.get(paises.getAdapterPosition()).getDescripcion());
                intent.putExtra("capital",Datos.get(paises.getAdapterPosition()).getCapital());
                intent.putExtra("poblacion",Datos.get(paises.getAdapterPosition()).getPoblacion());
                intent.putExtra("imagen",Datos.get(paises.getAdapterPosition()).getImagen());

                mContext.startActivity(intent);
            }
        });


        return  paises;
    }

    @Override
    public void onBindViewHolder(@NonNull paisesViewHolder holder, int position) {

        holder.tv_nombre.setText(Datos.get(position).getNombre());
        holder.tv_capital.setText(Datos.get(position).getCapital());
        Glide.with(mContext).load(Datos.get(position).getImagen()).apply(option).into(holder.img_bandera);


    }

    @Override
    public int getItemCount() {
        return Datos.size();
    }

    public static class paisesViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_nombre;
        TextView tv_capital;
        TextView tv_poblacion;
        AppCompatImageView  img_bandera;
        LinearLayout contenedorPaises;

        public paisesViewHolder(View itemView) {
            super(itemView);
            tv_nombre = itemView.findViewById(R.id.nombre);
            tv_capital = itemView.findViewById(R.id.capital);
            img_bandera = itemView.findViewById(R.id.bandera);
            contenedorPaises = itemView.findViewById(R.id.contenedor_paises_list);

        }
    }
}

