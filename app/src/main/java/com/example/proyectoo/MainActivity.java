package com.example.proyectoo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCrearLista, btnVerDetalleLista, btnCrearProducto, btnCategorias, btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Conexión de botones con el layout
        btnCrearLista = findViewById(R.id.btn_crear_lista);
        btnVerDetalleLista = findViewById(R.id.btn_lista_detalle);
        btnCrearProducto = findViewById(R.id.btn_crear_producto);
        btnCategorias = findViewById(R.id.btn_categorias);
        btnCerrarSesion = findViewById(R.id.btn_cerrar_sesion);

        // Acciones de cada botón
        btnCrearLista.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, CrearListaActivity.class)));

        btnVerDetalleLista.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ListaDetalleActivity.class)));

        btnCrearProducto.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, CrearProductoActivity.class)));

        btnCategorias.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, CategoriaActivity.class)));

        // Acción para cerrar sesión
        btnCerrarSesion.setOnClickListener(v -> {
            // Volver a la pantalla de bienvenida
            Intent intent = new Intent(MainActivity.this, BienvenidaActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Limpiar pila de pantallas
            startActivity(intent);
        });
    }
}
