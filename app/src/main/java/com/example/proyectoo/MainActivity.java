package com.example.proyectoo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnRegistro, btnPerfil, btnCrearLista, btnListaDetalle, btnCrearProducto, btnCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Este es el layout del menú que me pasaste

        // Conectar botones con el layout XML
        btnLogin = findViewById(R.id.btn_login);
        btnRegistro = findViewById(R.id.btn_registro);
        btnPerfil = findViewById(R.id.btn_perfil);
        btnCrearLista = findViewById(R.id.btn_crear_lista);
        btnListaDetalle = findViewById(R.id.btn_lista_detalle);
        btnCrearProducto = findViewById(R.id.btn_crear_producto);
        btnCategorias = findViewById(R.id.btn_categorias);

        // Intents para ir a cada formulario
        btnLogin.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, LoginActivity.class)));

        btnRegistro.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, RegistroActivity.class)));

        //btnPerfil.setOnClickListener(v ->
          //      startActivity(new Intent(MainActivity.this, PerfilActivity.class)));

        btnCrearLista.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, CrearListaActivity.class)));

        btnListaDetalle.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ListaDetalleActivity.class)));

        btnCrearProducto.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, CrearProductoActivity.class)));

        btnCategorias.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, CategoriaActivity.class)));
    }
}
