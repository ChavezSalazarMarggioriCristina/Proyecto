package com.example.proyectoo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistroActivity extends AppCompatActivity {

    private EditText campoNombre, campoCorreo, campoTelefono, campoContrasena;
    private Button botonRegistrarse;
    private TextView enlaceLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        // Ajustar padding si hay barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.contenedor_registro), (vista, insets) -> {
            Insets barras = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            vista.setPadding(barras.left, barras.top, barras.right, barras.bottom);
            return insets;
        });

        // Conectamos los elementos del XML con variables Java
        campoNombre = findViewById(R.id.et_nombre);
        campoCorreo = findViewById(R.id.et_correo);
        campoTelefono = findViewById(R.id.et_telefono);
        campoContrasena = findViewById(R.id.et_contrasena);
        botonRegistrarse = findViewById(R.id.btn_registrarse);
        enlaceLogin = findViewById(R.id.tv_ir_login);

        // Acción al presionar el botón "Registrarse"
        botonRegistrarse.setOnClickListener(v -> {
            String nombre = campoNombre.getText().toString().trim();
            String correo = campoCorreo.getText().toString().trim();
            String telefono = campoTelefono.getText().toString().trim();
            String contrasena = campoContrasena.getText().toString().trim();

            // Validamos que no estén vacíos
            if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // Simulamos un registro exitoso
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                // Redirigir al MainActivity
                Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Acción al presionar "¿Ya tienes cuenta? Inicia sesión"
        enlaceLogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
