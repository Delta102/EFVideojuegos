package com.example.examenfinal.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.examenfinal.Dao.CuentaDao;
import com.example.examenfinal.Dao.MovimientoDao;
import com.example.examenfinal.entities.Cuenta;
import com.example.examenfinal.entities.Movimiento;

@Database(entities = {Cuenta.class, Movimiento.class}, version = 1)
public abstract class ConfigDB extends RoomDatabase {

    public abstract CuentaDao cuentaDao();
    public abstract MovimientoDao movimientoDao();

    public static ConfigDB getInstance(Context context){
        return Room.databaseBuilder(context, ConfigDB.class, "com.example.examenfinal.database_DB")
                .allowMainThreadQueries().build();
    }
}
