package com.example.proyectoo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CrearListaActivity extends AppCompatActivity {

    private EditText etNombreLista, etDescripcionLista;
    private Button btnGuardarLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_lista);

        // Referencias a los campos de texto y botón
        etNombreLista = findViewById(R.id.et_nombre_lista);
        etDescripcionLista = findViewById(R.id.et_descripcion_lista);
        btnGuardarLista = findViewById(R.id.btn_guardar_lista);

        // Acción al presionar el botón
        btnGuardarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombreLista.getText().toString().trim();
                String descripcion = etDescripcionLista.getText().toString().trim();

                // Validar campos vacíos
                if (TextUtils.isEmpty(nombre)) {
                    etNombreLista.setError("Ingrese el nombre de la lista");
                    return;
                }

                if (TextUtils.isEmpty(descripcion)) {
                    etDescripcionLista.setError("Ingrese una descripción");
                    return;
                }

                // Enviar datos a ListaDetalleActivity
                Intent intent = new Intent(CrearListaActivity.this, ListaDetalleActivity.class);
                intent.putExtra("nombreLista", nombre);
                intent.putExtra("descripcionLista", descripcion);
                startActivity(intent);

                // Mostrar confirmación
                Toast.makeText(CrearListaActivity.this, "Lista creada con éxito", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
