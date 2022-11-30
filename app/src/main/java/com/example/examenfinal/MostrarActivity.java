package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.examenfinal.adapters.CuentaAdapter;
import com.example.examenfinal.database.ConfigDB;
import com.example.examenfinal.entities.Cuenta;
import com.example.examenfinal.services.CuentaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MostrarActivity extends AppCompatActivity {
    List<Cuenta> cuentas;
    RecyclerView listaRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        ConfigDB data = ConfigDB.getInstance(this);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://635a3e606f97ae73a62765ac.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CuentaService service = retrofit.create(CuentaService.class);
        List<Cuenta> lista = data.cuentaDao().listarCuentas();
        Call<List<Cuenta>> call = service.listarCuentas();
        call.enqueue(new Callback<List<Cuenta>>() {
            @Override
            public void onResponse(Call<List<Cuenta>> call, Response<List<Cuenta>> response) {

                cuentas = response.body();

                listaRv=findViewById(R.id.rvListar);

                CuentaAdapter adapter = new CuentaAdapter(cuentas);
                listaRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                listaRv.setHasFixedSize(true);
                listaRv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Cuenta>> call, Throwable t) {

            }
        });
    }
}