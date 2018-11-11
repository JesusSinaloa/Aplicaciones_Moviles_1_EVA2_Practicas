package com.example.eduardo.eva2_3_dulces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Principal extends AppCompatActivity {
    Button lanzar;
    Intent inLanzarSecun;
    EditText mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inLanzarSecun = new Intent(this, Secundaria.class);
        lanzar = findViewById(R.id.buttonLanzar);
        mensaje = findViewById(R.id.editTextMensaje);

        lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sCade = mensaje.getText().toString();
                inLanzarSecun.putExtra("MENSAJE", sCade);
                startActivity(inLanzarSecun);
            }
        });
    }

}
