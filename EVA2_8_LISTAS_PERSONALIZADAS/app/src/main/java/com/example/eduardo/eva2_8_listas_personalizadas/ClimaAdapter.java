package com.example.eduardo.eva2_8_listas_personalizadas;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eduardo.eva2_8_listas_personalizadas.clima;

public class ClimaAdapter extends ArrayAdapter<clima> {
    Context cContexto;
    int iLayout;
    clima[] aCiudadadesClima;
    public ClimaAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull clima[] objects) {
        super(context, resource, textViewResourceId, objects);
        cContexto = context;
        iLayout = resource;
        aCiudadadesClima = objects;
    }
    //METODO PAR ADIBUJAR EL LOYOUT
    //POSITON DEL ARRAY  //VIEW RESITRO QUE SE DIBUJA
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgVwClima;
        TextView ciudad, temperatura, descripcion;

        View vFila = convertView;
        if(vFila == null) {//SI ES NULO NO ESXITE LA FILA HAY QUE CREARLA
            //PARA CREAR LA LISTA USAMOS LAYOUTINFLATER
            LayoutInflater liVista = ((Activity)cContexto).getLayoutInflater();//ESTE OBJETO NOS PERMITE CREAR LA LISTA
            vFila = liVista.inflate(iLayout, parent, false);
        }

        //VINCULAR LOS WIDGETS
        imgVwClima = vFila.findViewById(R.id.imageViewClima);
        ciudad = vFila.findViewById(R.id.textViewCiudad);
        temperatura = vFila.findViewById(R.id.textViewGrados);
        descripcion = vFila.findViewById(R.id.textViewDescripcion);

        //LENAR DATOS
                clima actual = aCiudadadesClima[position];
        imgVwClima.setImageResource(actual.imagen);
        ciudad.setText(actual.nombreCiudad);
        descripcion.setText(actual.descripcion);
        temperatura.setText(actual.temperatura);




        return vFila;
    }
}
