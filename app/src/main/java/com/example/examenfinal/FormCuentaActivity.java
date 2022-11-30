package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examenfinal.database.ConfigDB;
import com.example.examenfinal.entities.Cuenta;
import com.example.examenfinal.services.CuentaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormCuentaActivity extends AppCompatActivity {

    EditText etNom;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etNom = findViewById(R.id.etNombre);
        btnRegistro = findViewById(R.id.btnCrearCuenta);

        Cuenta cuenta = new Cuenta();
        ConfigDB data = ConfigDB.getInstance(this);



        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cuenta.nombre = etNom.getText().toString();
                data.cuentaDao().crearCuenta(cuenta);

                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://635a3e606f97ae73a62765ac.mockapi.io/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                CuentaService service = retrofit.create(CuentaService.class);
                service.crear(cuenta).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("MAIN_APP", "RESPONSE" + response.code());
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }
        });
    }
}