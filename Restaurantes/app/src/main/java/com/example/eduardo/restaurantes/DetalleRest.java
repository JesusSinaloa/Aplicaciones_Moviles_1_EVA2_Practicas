package com.example.eduardo.restaurantes;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DetalleRest extends AppCompatActivity {
    //DECLARACION DE INTENTOS
    Intent inRecibidos, inLlamar;
    //DECLARACION DE WIDGETS
    TextView nomRest, descRest, DirRest, CiudRest, TelRest;
    ImageView imageRestD;
    Button llamar;
    //DECLARACION DE VARIABLES
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_rest);
        //VINCULACION
        nomRest = findViewById(R.id.textViewNomRestD);
        descRest = findViewById(R.id.textViewDesRestD);
        DirRest = findViewById(R.id.textViewDirRestD);
        CiudRest = findViewById(R.id.textViewCiudadRestD);
        TelRest = findViewById(R.id.textViewTelRestD);
        imageRestD = findViewById(R.id.imageViewRestD);
        llamar = findViewById(R.id.buttonLlamar);

        inRecibidos = getIntent();

        final Restaurante arrayObjeto = (Restaurante) inRecibidos.getSerializableExtra("array");

        nomRest.setText(arrayObjeto.nombre.toString());
        descRest.setText(arrayObjeto.desc.toString());
        DirRest.setText(arrayObjeto.dir.toString());
        CiudRest.setText(arrayObjeto.ciudad.toString());
        TelRest.setText(arrayObjeto.tel.toString());
        image = arrayObjeto.imageRest;
        imageRestD.setImageResource(image);

//ESTABLEZCO LLAMADA
        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"PROCESANDO INFORMACION", Toast.LENGTH_SHORT).show();

                inLlamar = new Intent(Intent.ACTION_CALL);
                inLlamar.setData(Uri.parse("tel:"+arrayObjeto.tel.toString()));

                if (ActivityCompat.checkSelfPermission(DetalleRest.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(inLlamar);
            }
        });

    }
}
