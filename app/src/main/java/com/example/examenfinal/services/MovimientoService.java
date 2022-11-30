package com.example.examenfinal.services;

import com.example.examenfinal.entities.Cuenta;
import com.example.examenfinal.entities.Movimiento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MovimientoService {

    @POST("Movimiento")
    Call<Void> crear (@Body Movimiento cuenta);

    @GET("Movimiento")
    Call<List<Movimiento>> listarCuentas();

}
