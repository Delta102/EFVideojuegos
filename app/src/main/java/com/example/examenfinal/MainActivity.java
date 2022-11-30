package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMostrar, btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMostrar = findViewById(R.id.btnMostrar);
        btnCrear = findViewById(R.id.btnCrear);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaFormulario();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearCuenta();
            }
        });
    }

    void listaFormulario(){
        Intent intent = new Intent(getApplicationContext(), MostrarActivity.class);
        startActivity(intent);
    }

    void crearCuenta(){
        Intent intent = new Intent(getApplicationContext(), FormCuentaActivity.class);
        startActivity(intent);
    }
}