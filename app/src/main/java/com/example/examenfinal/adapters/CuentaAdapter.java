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
import com.example.examenfinal.MostrarMovimientoActivity;
import com.example.examenfinal.R;
import com.example.examenfinal.entities.Cuenta;

import java.util.List;

public class CuentaAdapter extends RecyclerView.Adapter {

    List<Cuenta> datos;
    Button btnRegistro, btnMostrar;

    public CuentaAdapter (List<Cuenta> cuentaList){
        this.datos = cuentaList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_cuenta, parent, false);
        return new APICuentaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvnombre = holder.itemView.findViewById(R.id.txtNombre);
        tvnombre.setText(datos.get(position).nombre);

        btnRegistro = holder.itemView.findViewById(R.id.btnMovimiento);
        btnMostrar = holder.itemView.findViewById(R.id.button2);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), FormMovimientoActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), MostrarMovimientoActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    static class APICuentaViewHolder extends RecyclerView.ViewHolder{

        public APICuentaViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }
}
