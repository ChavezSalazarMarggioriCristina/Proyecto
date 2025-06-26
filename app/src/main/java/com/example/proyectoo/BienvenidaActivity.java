package com.example.proyectoo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BienvenidaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        Button botonIniciarSesion = findViewById(R.id.boton_ir_login);
        botonIniciarSesion.setOnClickListener(v -> {
            Intent intent = new Intent(BienvenidaActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
