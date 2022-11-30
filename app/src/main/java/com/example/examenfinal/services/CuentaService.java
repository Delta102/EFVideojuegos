package com.example.examenfinal.services;

import com.example.examenfinal.entities.Cuenta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CuentaService {
    @POST("Cuenta")
    Call<Void> crear (@Body Cuenta cuenta);

    @GET("Cuenta")
    Call<List<Cuenta>> listarCuentas();
}
