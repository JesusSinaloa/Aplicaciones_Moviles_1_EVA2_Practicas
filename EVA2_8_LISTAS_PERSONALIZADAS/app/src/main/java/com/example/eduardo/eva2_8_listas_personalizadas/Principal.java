package com.example.eduardo.eva2_8_listas_personalizadas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity
{
    ListView listViewclima;

    clima[] aCiudades = {
            new clima("Chihuahua", "soleado", 32, R.drawable.sunny),
            new clima("Delicias", "lluvioso", 32, R.drawable.rainy),
            new clima("Juarez", "soleado", 32, R.drawable.sunny),
            new clima("Tokio", "frio", 32, R.drawable.cloudy),
            new clima("USA", "templado", 32, R.drawable.cloudy),
            new clima("Tabasco", "soleado", 32, R.drawable.sunny),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        listViewclima = findViewById(R.id.lstClima);
        listViewclima.setAdapter(new ClimaAdapter(this, R.layout.layout_clima, aCiudades));


    }
}
