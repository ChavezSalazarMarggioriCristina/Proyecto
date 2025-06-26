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

public class LoginActivity extends AppCompatActivity {

    private EditText campoCorreo, campoContrasena;
    private Button botonIniciarSesion;
    private TextView enlaceRegistro;

    // Datos fijos de acceso
    private final String correoValido = "usuario@demo.com";
    private final String contrasenaValida = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (vista, insets) -> {
            Insets barras = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            vista.setPadding(barras.left, barras.top, barras.right, barras.bottom);
            return insets;
        });

        campoCorreo = findViewById(R.id.et_correo);
        campoContrasena = findViewById(R.id.et_contrasena);
        botonIniciarSesion = findViewById(R.id.btn_iniciar_sesion);
        enlaceRegistro = findViewById(R.id.tv_ir_registro);

        // Acción botón "Iniciar sesión"
        botonIniciarSesion.setOnClickListener(v -> {
            String correo = campoCorreo.getText().toString().trim();
            String contrasena = campoContrasena.getText().toString().trim();

            if (correo.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            } else if (correo.equals(correoValido) && contrasena.equals(contrasenaValida)) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });

        // Enlace para ir a registro
        enlaceRegistro.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
        });
    }
}
