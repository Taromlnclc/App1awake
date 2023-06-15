package com.example.app1awake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MuestraDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
     // Forma facil de pasar el valor a otra activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            boolean temaOscuro = extras.getBoolean("tema");
            if (!temaOscuro) {
                setTheme(R.style.Theme_temaAwakedia);
            } else {
                setTheme(R.style.Theme_temaAwakenoche);
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_datos);

        TextView myTitle = findViewById(R.id.miTituloReg);
        myTitle.setText(R.string.miTitulo2);


        if (extras != null) {
            // Obtener los valores utilizando las claves
            String nombre = extras.getString("nombre");
            String apellido = extras.getString("apellido");
            String email = extras.getString("email");
            // y se muestran
            TextView myData = findViewById(R.id.muestraDato);
            String dataX = nombre + " " +  apellido + "                                   " + email;
            myData.setText(dataX);

        }
    }
}