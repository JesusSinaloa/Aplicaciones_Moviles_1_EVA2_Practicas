package com.example.eduardo.eva2_6_resultados_lista;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    TextView resultado, txtViewtotal;
    Button lanzar, calcTotal;
    Intent inResta;
    Intent inCalTotal;
    final int LISTA_RESTA = 100;
    final int RESULT_CALC = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        resultado = findViewById(R.id.textViewResultado);
        lanzar = findViewById(R.id.buttonLanzar);
        inResta = new Intent(this, Secundaria.class);
        inCalTotal = new Intent(this, Tercera.class);
        txtViewtotal = findViewById(R.id.textViewTotalOrden);
        calcTotal = findViewById(R.id.buttonCalcularTotal);

        lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inResta, LISTA_RESTA);
            }
        });

        calcTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inCalTotal, RESULT_CALC);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == LISTA_RESTA){//QUE TE DEVUELVA DE TIPO LISTA
            if(resultCode == Activity.RESULT_OK){//QUE SI TE LO HAYA ENVIADO
                int iResta = data.getIntExtra("RESTAURANTE", 0);
                resultado.setText(Datos.sResta[iResta]);

            }
        }
        if (requestCode == RESULT_CALC) {
            if (resultCode == Activity.RESULT_OK) {
                int total = data.getIntExtra("TOTAL", 0);

               txtViewtotal.setText(String.valueOf(total));

            }
        }
    }
}
