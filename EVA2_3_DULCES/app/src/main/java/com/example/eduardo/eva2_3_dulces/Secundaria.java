package com.example.eduardo.eva2_3_dulces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {
Intent inLeer;
TextView mostrar;
Button cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        //CREAR ETIQUETA
        mostrar = findViewById(R.id.textView2Mostrar);
        cerrar = findViewById(R.id.buttonCerrar);

        //RECUEPERAR EL INTENTO
        inLeer = getIntent();
        //LEER EL EXTRA QUE TRAE EEL INTENTO
        mostrar.setText(inLeer.getStringExtra("MENSAJE"));

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
