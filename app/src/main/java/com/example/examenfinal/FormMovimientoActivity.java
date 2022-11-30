package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import com.example.examenfinal.database.ConfigDB;
import com.example.examenfinal.entities.Movimiento;
import com.google.gson.Gson;

import java.util.List;

public class FormMovimientoActivity extends AppCompatActivity {

    EditText etMonto, etMotivo, etLongitud, etLatitud;
    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_movimiento);

        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.Tipo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        Spinner st = findViewById(R.id.spnTipo);
        st.setAdapter(adapter);

        Movimiento movimiento = new Movimiento();

        ConfigDB data = ConfigDB.getInstance(this);

        etMonto = findViewById(R.id.etMonto);
        etMotivo = findViewById(R.id.etMotivo);
        etLongitud = findViewById(R.id.etLong);
        etLatitud = findViewById(R.id.etLat);

        btnCrear = findViewById(R.id.btnRegistroMovimiento);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movimiento.monto = Float.parseFloat(etMonto.getText().toString());
                movimiento.motivo = etMotivo.getText().toString();
                movimiento.longitud = etLongitud.getText().toString();
                movimiento.latitud = etLatitud.getText().toString();
                movimiento.tipo = st.getSelectedItem().toString();

                data.movimientoDao().guardar(movimiento);
                List<Movimiento> movimientos = data.movimientoDao().listarMovimientos();
                Log.i("MAIN_APP", new Gson().toJson(movimientos));
            }
        });
    }
}