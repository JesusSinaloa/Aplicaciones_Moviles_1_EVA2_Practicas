package com.example.eduardo.restaurantes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;

public class Principal extends AppCompatActivity {
    //DECLARACION DE WIDGETS
    ListView lstRest;
    //DECLARACION DE INTENTOS
    Intent inEnviar;
    //CREAR ARREGLO
    Restaurante [] restaurantes = {

            new Restaurante("barrafina", "restaurante1", "independencia", "cmx", "4206547", R.drawable.barrafina),
            new Restaurante("bourkes", "restaurante1", "independencia", "cmx", "4206547", R.drawable.bourkestreetbakery),
            new Restaurante("cafedead", "restaurante1", "independencia", "cmx", "4206547", R.drawable.cafedeadend),
            new Restaurante("cafelore", "restaurante1", "independencia", "cmx", "4206547", R.drawable.cafeloisl),
            new Restaurante("confessional", "restaurante1", "independencia", "cmx", "4206547", R.drawable.confessional),
            new Restaurante("donostia", "restaurante1", "independencia", "cmx", "4206547", R.drawable.donostia),
            new Restaurante("ficeleaves", "restaurante1", "independencia", "cmx", "4206547", R.drawable.fiveleaves),
            new Restaurante("forkeere", "restaurante1", "independencia", "cmx", "4206547", R.drawable.forkeerestaurant),
            new Restaurante("grhamavenue", "restaurante1", "independencia", "cmx", "4206547", R.drawable.grahamavenuemeats),
            new Restaurante("haighschool", "restaurante1", "independencia", "cmx", "4206547", R.drawable.haighschocolate),
            new Restaurante("homei", "restaurante1", "independencia", "cmx", "4206547", R.drawable.homei),
            new Restaurante("palomino", "restaurante1", "independencia", "cmx", "4206547", R.drawable.palominoespresso),
            new Restaurante("petitel", "restaurante1", "independencia", "cmx", "4206547", R.drawable.petiteoyster),
            new Restaurante("posatelier", "restaurante1", "independencia", "cmx", "4206547", R.drawable.posatelier),
            new Restaurante("royaloak", "restaurante1", "independencia", "cmx", "4206547", R.drawable.royaloak),
            new Restaurante("teakha", "restaurante1", "independencia", "cmx", "4206547", R.drawable.teakha),
            new Restaurante("thaicafe", "restaurante1", "independencia", "cmx", "4206547", R.drawable.thaicafe),
            new Restaurante("traif", "restaurante1", "independencia", "cmx", "4206547", R.drawable.traif),
            new Restaurante("upstate", "restaurante1", "independencia", "cmx", "4206547", R.drawable.upstate),
            new Restaurante("waffle", "restaurante1", "independencia", "cmx", "4206547", R.drawable.wafflewolf),


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //VINCULACION DE WIDGETS
        lstRest = findViewById(R.id.lstViewRest);

        //CARGO MI ADAPTADOR
        RestAdapter miAdaptadorRest = new RestAdapter(Principal.this,R.layout.layout_rest,restaurantes);//LE MANDAMOS AL CONTRUCTOR DE LA CLASE EL CONTEXTO; LA LISTA Y ILAYOUT
        lstRest.setAdapter(miAdaptadorRest);


        lstRest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                inEnviar = new Intent(Principal.this, DetalleRest.class);
                inEnviar.putExtra("array", (Serializable) lstRest.getItemAtPosition(position));
                startActivity(inEnviar);

            }
        });



    }
}
