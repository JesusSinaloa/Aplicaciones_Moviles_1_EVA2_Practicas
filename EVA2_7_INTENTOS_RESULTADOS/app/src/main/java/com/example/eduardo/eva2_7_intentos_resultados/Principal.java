package com.example.eduardo.eva2_7_intentos_resultados;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case BUSCAR_CONTACTOS:
                if (resultCode == Activity.RESULT_OK) {
                    String sResu = data.getDataString();
                    Intent llamar = new Intent(Intent.ACTION_VIEW, Uri.parse(sResu));


                        startActivity(llamar);
                        resultado.setText(sResu.toString());


                }
                break;
            case BUSCAR_IMAGENES:

                break;
                default:
        }
    }

    TextView resultado;
    Button btn1, btn2;
    Intent inContactos, inImagenes;
    Uri uContactos, uImagenes;
    final int BUSCAR_CONTACTOS = 1000;//CODIGOS QUE INICIALIZA LA ACTIVIDAD
    final int BUSCAR_IMAGENES = 2000;//CODIGOS QUE INICIALIZA LA ACTIVIDAD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        resultado = findViewById(R.id.textViewResultado);
        btn1 = findViewById(R.id.buttonLanzar);
        btn2 = findViewById(R.id.buttonImages);
        uContactos = ContactsContract.Contacts.CONTENT_URI;
        uImagenes = Uri.parse("content://media/external/images/media");
        inContactos = new Intent(Intent.ACTION_PICK, uContactos);
        inImagenes = new Intent(Intent.ACTION_PICK, uImagenes);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inContactos, BUSCAR_CONTACTOS);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inImagenes, BUSCAR_IMAGENES);
            }
        });
    }
}
