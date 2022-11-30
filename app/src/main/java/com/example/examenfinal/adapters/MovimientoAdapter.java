package com.example.examenfinal.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinal.FormMovimientoActivity;
import com.example.examenfinal.R;
import com.example.examenfinal.entities.Cuenta;
import com.example.examenfinal.entities.Movimiento;

import java.util.List;

public class MovimientoAdapter extends RecyclerView.Adapter{

    List<Movimiento> datos;
    Button btnRegistro;

    public MovimientoAdapter (List<Movimiento> cuentaList){
        this.datos = cuentaList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_cuenta, parent, false);
        return new CuentaAdapter.APICuentaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvMonto = holder.itemView.findViewById(R.id.txtMonto);

        tvMonto.setText(Float.toString(datos.get(position).monto));

        TextView tvMotivo = holder.itemView.findViewById(R.id.txtMotivo);
        tvMonto.setText(datos.get(position).motivo);

        TextView tvTipo = holder.itemView.findViewById(R.id.txtTipo);
        tvTipo.setText(datos.get(position).tipo);

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    static class APIMovimientoViewHolder extends RecyclerView.ViewHolder{

        public APIMovimientoViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }
}
