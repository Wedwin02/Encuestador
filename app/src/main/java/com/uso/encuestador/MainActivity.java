package com.uso.encuestador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText txbNombre,txbApellido,txbedad;
    CheckBox ckEnsalada,ckPasta,ckCarne;
    Spinner lista;
     private Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txbNombre = findViewById(R.id.txbNombre);
        txbApellido= findViewById(R.id.txbApellido);
        txbedad = findViewById(R.id.txbEdad);
        this.btnEnviar = findViewById(R.id.btnEnviar);
        ckEnsalada= findViewById(R.id.ckEnsalada);
        ckCarne = findViewById(R.id.chkCarnes);
        ckPasta= findViewById(R.id.ckPastas);
        lista = findViewById(R.id.spRestaurantes);


        this.btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String checado ="";
                String listaRestaurante = String.valueOf(lista.getSelectedItem());
                if(ckCarne.isChecked()){
                    checado+= "Carnes\n";
                }
                if(ckPasta.isChecked()){
                    checado+= "Pastas\n";
                }
                if(ckEnsalada.isChecked()){
                    checado+= "Ensaladas\n";
                }



                Intent u = new Intent(MainActivity.this, Respuesta.class);
                Bundle miBundle = new Bundle();
                if(validar()){
                miBundle.putString("nombre",txbNombre.getText().toString());
                miBundle.putString("apellido",txbApellido.getText().toString());
                miBundle.putString("edad",txbedad.getText().toString());
                miBundle.putString("checkeado",checado);
                miBundle.putString("restaurantes",listaRestaurante);



                u.putExtras(miBundle);
                startActivity(u);
                }
            }

            public boolean validar(){
                Boolean retorno =  true;

                String n = txbNombre.getText().toString();
                String a = txbApellido.getText().toString();
                String e = txbedad.getText().toString();

                if(n.isEmpty()){
                    txbNombre.setError("Este Campo no puede ser vacio.");
                    retorno = false;
                }
                if(a.isEmpty()){
                    txbApellido.setError("Este Campo no puede ser vacio.");
                    retorno = false;
                }
                if(e.isEmpty()){
                    txbedad.setError("Este Campo no puede ser vacio.");
                    retorno = false;
                }

                return retorno;

            }
        });







    }
}