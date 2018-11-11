package com.example.eduardo.eva2_1_intentos;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class Principal extends AppCompatActivity {
    //CONTRIYENDO WIDGETS
    EditText numero;
    Button llamar, llamar2, web;

    //CONTRUYENDO  INTENTO
    Intent inMarcar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //ENCONTRAR WIDGETS
        numero = findViewById(R.id.editTextPhone);
        llamar = findViewById(R.id.buttonLlamar);
        llamar2 = findViewById(R.id.buttonLlamar2);
        web = findViewById(R.id.buttonWEB);



        //METOD ONCLICK ACTION_DIAL
        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sTel = numero.getText().toString();
                sTel = "tel:" + sTel; //SE LE PEGA tel: APRA INDICAR QUE ES UN NUMERO DE TELEFONO

                //CONTRUIR INTENTO
                inMarcar = new Intent(Intent.ACTION_DIAL, Uri.parse(sTel));//MARCACION ACCION DIAL(PASA LA ACTIVIDAD) ACTION_CALL(TRUENA POR QUE LA APLICAICON NO TIENE PERMISOS)
                //EJECUTAR INTENTO
                // QUIEREN UNA RESPUESTA SI O NO
                startActivity(inMarcar);

            }
        });

        //METOD ONCLICK 2 PARA ACTION CALL
        llamar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sTel = numero.getText().toString();
                sTel = "tel:" + sTel; //SE LE PEGA tel: APRA INDICAR QUE ES UN NUMERO DE TELEFONO

                //CONTRUIR INTENTO
                inMarcar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));//MARCACION ACCION DIAL(PASA LA ACTIVIDAD) ACTION_CALL(TRUENA POR QUE LA APLICAICON NO TIENE PERMISOS)
                //EJECUTAR INTENTO
                // QUIEREN UNA RESPUESTA SI O NO
                startActivity(inMarcar);

            }
        });

        //METOD ONCLICK 3 PARA WEB
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //CONTRUIR INTENTO
                inMarcar = new Intent(Intent.ACTION_WEB_SEARCH);//MARCACION ACCION DIAL(PASA LA ACTIVIDAD) ACTION_CALL(TRUENA POR QUE LA APLICAICON NO TIENE PERMISOS)
                //EJECUTAR INTENTO
                // QUIEREN UNA RESPUESTA SI O NO
                //LOS EXTRAS SON INFORMACION QUE LE ENVIAS A LA APP
                inMarcar.putExtra(SearchManager.QUERY,"tacos");

            }
        });
    }



}
