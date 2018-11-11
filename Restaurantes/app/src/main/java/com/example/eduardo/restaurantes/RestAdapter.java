package com.example.eduardo.restaurantes;

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

public class RestAdapter extends ArrayAdapter {
    Context cContexto;
    int iLayout;
    Restaurante[] aRestaurantes;

    public RestAdapter(@NonNull Context context, int resource, @NonNull Restaurante[] objects) {
        super(context, resource, objects);

        cContexto = context;
        iLayout = resource;
        aRestaurantes = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgViewRest;
        TextView nombre, desc;

        View vFila = convertView;
        if(vFila == null) {//SI ES NULO NO ESXITE LA FILA HAY QUE CREARLA
            //PARA CREAR LA LISTA USAMOS LAYOUTINFLATER
            LayoutInflater liVista = ((Activity)cContexto).getLayoutInflater();//ESTE OBJETO NOS PERMITE CREAR LA LISTA
            vFila = liVista.inflate(iLayout, parent, false);
        }

        //VINCULAR LOS WIDGETS
        nombre = vFila.findViewById(R.id.textViewNombreL);
        desc = vFila.findViewById(R.id.textViewDescL);
        imgViewRest = vFila.findViewById(R.id.imageViewRestL);

        //LENAR DATOS

        Restaurante actual = aRestaurantes[position];
        imgViewRest .setImageResource(actual.imageRest);
        nombre.setText(actual.nombre);
        desc.setText(actual.desc);



        return vFila;

    }
}
