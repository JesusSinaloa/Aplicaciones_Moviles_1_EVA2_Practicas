package com.example.eduardo.eva2_6_resultados_lista;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tercera extends AppCompatActivity {
    EditText cantidad, precio;
    Button calcular;
    Intent inCalculo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        cantidad = findViewById(R.id.editTextCantidad);
        precio = findViewById(R.id.editTextPrecio);
        calcular = findViewById(R.id.buttonCalcular);

        //RECUPERAMOS EL INTENTO
        inCalculo = getIntent();


        calcular.setOnClickListener(new View.OnClickListener() {
            int Vcantidad;
            int Vprecio;
            int total;
            @Override
            public void onClick(View v) {
                Vcantidad = Integer.parseInt(cantidad.getText().toString());

                Vprecio = Integer.parseInt(precio.getText().toString());

                total = (Vcantidad * Vprecio);

                inCalculo.putExtra("TOTAL", total);//ENVIAAS EL RESULTADO CON LA LLAME LLAMADA TOTAL
                setResult(Activity.RESULT_OK, inCalculo);//DEVUELVO OK
                finish();
            }
        });
    }
}
