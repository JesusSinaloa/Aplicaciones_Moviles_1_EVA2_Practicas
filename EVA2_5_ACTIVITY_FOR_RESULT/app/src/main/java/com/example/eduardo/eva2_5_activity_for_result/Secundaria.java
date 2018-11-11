package com.example.eduardo.eva2_5_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Secundaria extends AppCompatActivity {
EditText datos;
Button enviar;
Intent inDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        datos = findViewById(R.id.editTextDatos);
        enviar = findViewById(R.id.buttonEnviar);
        inDatos = getIntent();//RECUPERAR INTENTO

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sCade = datos.getText().toString();
                inDatos.putExtra("DATOS", sCade);
                setResult(Activity.RESULT_OK, inDatos);
                finish();
            }
        });
    }
}
