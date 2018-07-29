package com.anevents.listapaises;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


class BusquedaDbAdapter extends RecyclerView.Adapter<BusquedaDbAdapter.ViewHolder> {

    private List<BusquedaDb> busquedaDb;

    public BusquedaDbAdapter(List<BusquedaDb> busquedaDb) {
        this.busquedaDb = busquedaDb;
    }

    @Override
    public BusquedaDbAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.busqueda_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BusquedaDbAdapter.ViewHolder holder, int position) {
        holder.nombre.setText(busquedaDb.get(position).nombre);
    }

    @Override
    public int getItemCount() {
        return busquedaDb.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre;

        public ViewHolder(View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.nombre);
        }
    }
}
