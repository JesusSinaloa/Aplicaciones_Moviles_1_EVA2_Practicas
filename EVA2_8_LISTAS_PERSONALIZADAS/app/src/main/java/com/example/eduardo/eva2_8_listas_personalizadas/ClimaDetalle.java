package com.example.eduardo.eva2_8_listas_personalizadas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ClimaDetalle extends AppCompatActivity {
    Intent  inDatos;
    ImageView imgVwClima;
    TextView ciudad, temperatura, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clima_detalle);
        imgVwClima = findViewById(R.id.imageViewClima);

        inDatos = getIntent();

        imgVwClima.setImageResource(inDatos.getIntExtra("IMG", R.drawable));
    }
}
