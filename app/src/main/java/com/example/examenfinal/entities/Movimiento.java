package com.example.examenfinal.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movimientos")
public class Movimiento {
    @PrimaryKey(autoGenerate = true)
    public int idMovimiento;
    public String tipo;
    public float monto;
    public String motivo;
    public String imagen;
    public String latitud;
    public String longitud;
}
