package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.examenfinal.adapters.CuentaAdapter;
import com.example.examenfinal.adapters.MovimientoAdapter;
import com.example.examenfinal.database.ConfigDB;
import com.example.examenfinal.entities.Cuenta;
import com.example.examenfinal.entities.Movimiento;
import com.example.examenfinal.services.CuentaService;
import com.example.examenfinal.services.MovimientoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MostrarMovimientoActivity extends AppCompatActivity {

    List<Movimiento> cuentas;
    RecyclerView listaRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        ConfigDB data = ConfigDB.getInstance(this);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://635a3e606f97ae73a62765ac.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovimientoService service = retrofit.create(MovimientoService.class);
        List<Movimiento> lista = data.movimientoDao().listarMovimientos();
        Call<List<Movimiento>> call = service.listarCuentas();
        call.enqueue(new Callback<List<Movimiento>>() {
            @Override
            public void onResponse(Call<List<Movimiento>> call, Response<List<Movimiento>> response) {

                cuentas = response.body();

                listaRv=findViewById(R.id.rvListaMov);

                MovimientoAdapter adapter = new MovimientoAdapter(cuentas);
                listaRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                listaRv.setHasFixedSize(true);
                listaRv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Movimiento>> call, Throwable t) {
            }
        });
    }
}