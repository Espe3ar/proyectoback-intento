package com.ucema.proga3.clase.Servicios;

import com.ucema.proga3.clase.Model.CanchaPaddle;

import java.util.List;

public interface ICanchaPaddleService {
    public CanchaPaddle createCanchaPaddle(int Numero, float PrecioxHora);
    public List<CanchaPaddle> findAll_CPaddle();
}
