package com.example.eduardo.eva2_5_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
TextView resultado;
Button lanzar;
Intent inLanzarSecun;
final int DATOS_SECUNDARIA = 100;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == DATOS_SECUNDARIA){//IDENTIFICAR QUE ACTIVIDAD ESTA MANDANDO
            if(resultCode == Activity.RESULT_OK) {//VERIFICAR QUE TIPO DE RESPUESTA
                            //AQUI EJECUTAN ALGUNA ACCION
                String sCade = data.getStringExtra("DATOS");
                resultado.setText(sCade);
            }
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        resultado = findViewById(R.id.textViewResultado);
        lanzar = findViewById(R.id.buttonLanzar);
        inLanzarSecun = new Intent(this, Secundaria.class);

        lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(inLanzarSecun);
                startActivityForResult(inLanzarSecun, DATOS_SECUNDARIA);

            }
        });


    }
}
