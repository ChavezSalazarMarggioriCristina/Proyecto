package com.example.proyectoo;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListaProductoActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProductos;
    private ProductoAdapter productoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_producto);

        recyclerViewProductos = findViewById(R.id.recycler_productos);
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this));

        productoAdapter = new ProductoAdapter(RepositorioProducto.obtenerProductos());
        recyclerViewProductos.setAdapter(productoAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        productoAdapter.notifyDataSetChanged(); // Actualiza la vista cada vez que vuelve
    }
}
