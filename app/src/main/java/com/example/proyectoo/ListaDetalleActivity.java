package com.example.proyectoo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListaDetalleActivity extends AppCompatActivity {

    private static final int REQUEST_CREAR_PRODUCTO = 100;

    RecyclerView recyclerProductos;
    List<Producto> productos;
    ProductoAdapter adapter;

    TextView tvNombreLista, tvDescripcionLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_detalle);

        // Inicializar TextView para mostrar datos recibidos
        tvNombreLista = findViewById(R.id.tv_nombre_lista);
        tvDescripcionLista = findViewById(R.id.tv_descripcion_lista);

        // Obtener datos desde el Intent
        String nombreLista = getIntent().getStringExtra("nombreLista");
        String descripcionLista = getIntent().getStringExtra("descripcionLista");

        // Mostrar los datos en los TextViews
        if (nombreLista != null) {
            tvNombreLista.setText("Nombre: " + nombreLista);
        }

        if (descripcionLista != null) {
            tvDescripcionLista.setText("Descripción: " + descripcionLista);
        }

        // Configurar RecyclerView y productos iniciales
        recyclerProductos = findViewById(R.id.recycler_productos);
        recyclerProductos.setLayoutManager(new LinearLayoutManager(this));

        productos = new ArrayList<>();
        productos.add(new Producto("Pan", "Supermercado", false));
        productos.add(new Producto("Ibuprofeno", "Farmacia", true));
        productos.add(new Producto("Pintura", "Ferretería", false));

        adapter = new ProductoAdapter(productos);
        recyclerProductos.setAdapter(adapter);

        // Abrir CrearProductoActivity desde el botón flotante
        findViewById(R.id.fab_agregar_producto).setOnClickListener(v -> {
            Intent intent = new Intent(ListaDetalleActivity.this, CrearProductoActivity.class);
            startActivityForResult(intent, REQUEST_CREAR_PRODUCTO);
        });
    }

    // Recibir datos del nuevo producto y agregarlo a la lista
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CREAR_PRODUCTO && resultCode == RESULT_OK && data != null) {
            String nombre = data.getStringExtra("nombre");
            double precio = data.getDoubleExtra("precio", 0);
            int cantidad = data.getIntExtra("cantidad", 1);

            // Crear y agregar el producto (usa categoría "General" y no comprado por defecto)
            Producto nuevoProducto = new Producto(nombre, "General", false); // Puedes mejorar esta clase luego

            productos.add(nuevoProducto);
            adapter.notifyItemInserted(productos.size() - 1);

            Toast.makeText(this, "Producto agregado", Toast.LENGTH_SHORT).show();
        }
    }
}
