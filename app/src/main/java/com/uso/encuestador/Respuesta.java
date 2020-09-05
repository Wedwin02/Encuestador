package com.uso.encuestador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Respuesta extends AppCompatActivity {
    TextView rNombre,rApellido,rEdad,rChe,rRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta);

        recibirDatos();
    }
     private void recibirDatos(){
        Bundle miBundle = getIntent().getExtras();
        rNombre = findViewById(R.id.lblNombre);
        rApellido = findViewById(R.id.lblApellido);
        rEdad = findViewById(R.id.lblEdad);
        rChe = findViewById(R.id.lblComidas);
        rRestaurante = findViewById(R.id.lblRestaurantes);

        if(miBundle!=null){
            String n = miBundle.getString("nombre");
            String a = miBundle.getString("apellido");
            String e = miBundle.getString("edad");
            String c = miBundle.getString("checkeado");
            String rS = miBundle.getString("restaurantes");

            rNombre.setText(n);
            rApellido.setText(a);
            rEdad.setText(e);
            rChe.setText(c);
            rRestaurante.setText(rS);


        }

     }

}