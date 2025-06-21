package com.example.proyectoo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerListas;
    ListaAdapter adapter;
    List<ListaCompra> listaEjemplo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerListas = findViewById(R.id.recycler_listas);
        recyclerListas.setLayoutManager(new LinearLayoutManager(this));

        // Datos de prueba
        listaEjemplo = new ArrayList<>();
        listaEjemplo.add(new ListaCompra("Mercado", "Compras del domingo"));
        listaEjemplo.add(new ListaCompra("Farmacia", "Medicinas para mamá"));
        listaEjemplo.add(new ListaCompra("Ferretería", "Material de pintura"));
        listaEjemplo.add(new ListaCompra("cafeteria", "café con pan"));

        adapter = new ListaAdapter(listaEjemplo);
        recyclerListas.setAdapter(adapter);
    }
}
