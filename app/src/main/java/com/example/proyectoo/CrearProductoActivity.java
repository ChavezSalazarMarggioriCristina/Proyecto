package com.example.proyectoo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CrearProductoActivity extends AppCompatActivity {

    private EditText campoNombre, campoPrecio, campoCantidad;
    private Button botonGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Opcional para diseño de pantalla completa
        setContentView(R.layout.activity_crear_producto);

        // Ajuste de márgenes por sistema (por si usas pantalla completa o notch)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (vista, insets) -> {
            Insets barrasSistema = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            vista.setPadding(barrasSistema.left, barrasSistema.top, barrasSistema.right, barrasSistema.bottom);
            return insets;
        });

        // Enlazar con los elementos del XML
        campoNombre = findViewById(R.id.et_nombre_producto);
        campoPrecio = findViewById(R.id.et_precio_producto);
        campoCantidad = findViewById(R.id.et_cantidad_producto);
        botonGuardar = findViewById(R.id.btn_guardar_producto);

        // Acción al hacer clic en "Guardar producto"
        botonGuardar.setOnClickListener(v -> {
            String nombre = campoNombre.getText().toString().trim();
            String precio = campoPrecio.getText().toString().trim();
            String cantidad = campoCantidad.getText().toString().trim();

            // Validación de campos
            if (nombre.isEmpty() || precio.isEmpty() || cantidad.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // Por ahora solo mostramos un mensaje
                Toast.makeText(this, "Producto guardado exitosamente", Toast.LENGTH_SHORT).show();

                // Aquí podrías guardar el producto en una lista más adelante
                campoNombre.setText("");
                campoPrecio.setText("");
                campoCantidad.setText("");
            }
        });
    }
}
