package com.example.eduardo.eva2_6_resultados_lista;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Secundaria extends AppCompatActivity
implements ListView.OnItemClickListener{
ListView lstResta;
Intent inDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        lstResta = findViewById(R.id.listViewRestaurantes);
        //LISTA
        //CREAR EL ADAPTADOR
        //ASIGANR EL ADAPTADOR                                                                          //ARRAY EN LA CLASE DATOS
        lstResta.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Datos.sResta));
        //ASIGNAR EL LISTENER
        lstResta.setOnItemClickListener(this);
        //FIN LISTA
        //RECUPERAMOS INTENTO
        inDatos = getIntent();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        inDatos.putExtra("RESTAURANTE", position);
        setResult(Activity.RESULT_OK,inDatos);//DEVUELVO OK
        finish();
    }
}
