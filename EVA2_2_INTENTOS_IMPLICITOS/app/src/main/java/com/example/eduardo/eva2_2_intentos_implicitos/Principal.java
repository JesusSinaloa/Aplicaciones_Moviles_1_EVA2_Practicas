package com.example.eduardo.eva2_2_intentos_implicitos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
    Button lanzar;
    Intent inLanzarSecun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

    inLanzarSecun = new Intent(this, Secundaria.class);

       lanzar = findViewById(R.id.buttonLanzar);

        lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BOTON PARA LANZAR LAS
                startActivity(inLanzarSecun);
            }
        });
       

    }
}
