package com.ucema.proga3.clase.Servicios;

import com.ucema.proga3.clase.Model.CanchaPaddle;
import com.ucema.proga3.clase.Model.CanchaTennis;

import java.util.List;

public interface ICanchaTennisService {
    public CanchaTennis createCanchaTennis(int Numero, float PrecioxHora);
    public List<CanchaTennis> findAll_CTennis();
}
