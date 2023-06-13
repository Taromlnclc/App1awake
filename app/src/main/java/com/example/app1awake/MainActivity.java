package com.example.app1awake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
        Intent intent = new Intent(this, MuestraDatos.class);
        EditText nomText = findViewById(R.id.editNombre);
        EditText apeText = findViewById(R.id.editApellido);
        EditText maiText = findViewById(R.id.editEmail);
        intent.putExtra("nombre", nomText.getText().toString());
        intent.putExtra("apellido", apeText.getText().toString());
        intent.putExtra("email", maiText.getText().toString());
        startActivity(intent);
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