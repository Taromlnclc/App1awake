package com.example.app1awake;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTitle = findViewById(R.id.miTitulo);
        myTitle.setText(R.string.miTitulo);

        TextView myName = findViewById(R.id.miNombre);
        myName.setText(R.string.miNombre);

        TextView mySur = findViewById(R.id.miApellido);
        mySur.setText(R.string.miApellido);

        TextView myEmail = findViewById(R.id.miMail);
        myEmail.setText(R.string.miMail);

        Button mySend = findViewById(R.id.miEnvio);
        mySend.setText(R.string.miEnvio);

    }
    //boton de ingreso datos
    public void botonClick(View view) {
        Button mySend = findViewById(R.id.miEnvio);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.boton_resize);
        mySend.startAnimation(animation);

        EditText nomText = findViewById(R.id.editNombre);
        EditText apeText = findViewById(R.id.editApellido);
        EditText maiText = findViewById(R.id.editEmail);

        String nombre = nomText.getText().toString();
        String apellido = apeText.getText().toString();
        String correo = maiText.getText().toString();

        if (!validarCampos(nombre,apellido,correo,nomText,apeText,maiText)) {
            // Si esta bien avanza
            Intent intent = new Intent(this, MuestraDatos.class);
            intent.putExtra("nombre", nombre);
            intent.putExtra("apellido", apellido);
            intent.putExtra("email", correo);
            startActivity(intent);
        }

    }

    // Validación de los campos nombre, apellido y correo electrónico
    public boolean validarCampos(String nombre, String apellido, String correo, EditText nom, EditText ape,EditText eme ) {
        if (nombre.isEmpty()) {
            // Mostrar mensaje y foco para el campo nombre
            nom.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(nom, InputMethodManager.SHOW_IMPLICIT);
            mostrarAlerta(" nombre no ingresado");
            return true;
        }
        if (apellido.isEmpty()) {
            // Mostrar mensaje y foco para el campo apellido
            ape.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(ape, InputMethodManager.SHOW_IMPLICIT);
            mostrarAlerta(" apellido no ingresado");
            return true;
        }
        if (correo.isEmpty()) {
            // Mostrar mensaje y fodo para el campo correo electrónico
            eme.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(eme, InputMethodManager.SHOW_IMPLICIT);
            mostrarAlerta(" correo no ingresado");
            return true;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            // Mostrar mensaje y foco, formato de correo electrónico inválido
            eme.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(eme, InputMethodManager.SHOW_IMPLICIT);
            mostrarAlerta(" revisar formato de correo");
            return true;
        }
        return false;
    }

    // Mensajes de alerta
    private void mostrarAlerta(String atributo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Falta " + atributo + ".")
                .setMessage("Revisar informacion, " + atributo + ".")
                .setPositiveButton("Aceptar", (dialog, which) -> dialog.dismiss());
        AlertDialog alert = builder.create();
        alert.show();
    }

    //LOGCAT
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"On Start!");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"On Resume!");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"On Pausa!");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"On Stop!");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"On Restart!");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"On Destroy!");
    }
}