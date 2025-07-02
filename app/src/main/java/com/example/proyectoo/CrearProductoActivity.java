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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_producto);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (vista, insets) -> {
            Insets barrasSistema = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            vista.setPadding(barrasSistema.left, barrasSistema.top, barrasSistema.right, barrasSistema.bottom);
            return insets;
        });

        campoNombre = findViewById(R.id.et_nombre_producto);
        campoPrecio = findViewById(R.id.et_precio_producto);
        campoCantidad = findViewById(R.id.et_cantidad_producto);
        botonGuardar = findViewById(R.id.btn_guardar_producto);

        botonGuardar.setOnClickListener(v -> {
            String nombre = campoNombre.getText().toString().trim();
            String precioStr = campoPrecio.getText().toString().trim();
            String cantidadStr = campoCantidad.getText().toString().trim();

            if (nombre.isEmpty() || precioStr.isEmpty() || cantidadStr.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    double precio = Double.parseDouble(precioStr);
                    int cantidad = Integer.parseInt(cantidadStr);

                    // Creamos el producto
                    Producto nuevoProducto = new Producto(nombre, "General", false, precio, cantidad);

                    // Lo agregamos a la lista compartida
                    RepositorioProducto.agregarProducto(nuevoProducto);

                    // Mostramos mensaje
                    Toast.makeText(this, "Producto guardado exitosamente", Toast.LENGTH_SHORT).show();

                    // Cerramos esta Activity y regresamos al menú principal
                    finish();

                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Precio o cantidad inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
