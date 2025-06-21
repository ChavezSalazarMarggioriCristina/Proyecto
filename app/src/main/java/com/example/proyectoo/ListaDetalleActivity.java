package com.example.proyectoo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListaDetalleActivity extends AppCompatActivity {

    RecyclerView recyclerProductos;
    List<Producto> productos;
    ProductoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_detalle);

        recyclerProductos = findViewById(R.id.recycler_productos);
        recyclerProductos.setLayoutManager(new LinearLayoutManager(this));

        productos = new ArrayList<>();
        productos.add(new Producto("Pan", "Supermercado", false));
        productos.add(new Producto("Ibuprofeno", "Farmacia", true));
        productos.add(new Producto("Pintura", "Ferretería", false));

        adapter = new ProductoAdapter(productos);
        recyclerProductos.setAdapter(adapter);
    }
}
