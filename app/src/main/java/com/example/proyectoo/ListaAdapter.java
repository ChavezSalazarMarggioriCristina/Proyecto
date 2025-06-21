package com.example.proyectoo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder> {

    private final List<ListaCompra> listaDeCompras;

    public ListaAdapter(List<ListaCompra> listaDeCompras) {
        this.listaDeCompras = listaDeCompras;
    }

    @NonNull
    @Override
    public ListaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista, parent, false);
        return new ViewHolder(vistaItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAdapter.ViewHolder holder, int position) {
        ListaCompra lista = listaDeCompras.get(position);
        holder.tvNombre.setText(lista.getNombre());
        holder.tvDescripcion.setText(lista.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return listaDeCompras.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tv_nombre_lista);
            tvDescripcion = itemView.findViewById(R.id.tv_descripcion_lista);
        }
    }
}
