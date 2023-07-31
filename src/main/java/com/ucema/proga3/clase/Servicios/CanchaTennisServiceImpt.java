package com.ucema.proga3.clase.Servicios;

import com.ucema.proga3.clase.Model.CanchaPaddle;
import com.ucema.proga3.clase.Model.CanchaTennis;
import com.ucema.proga3.clase.Repositorios.ICanchaTennisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanchaTennisServiceImpt implements ICanchaTennisService {

    @Autowired
    private ICanchaTennisRepository canchaTennisRepository;

    @Override
    public CanchaTennis createCanchaTennis(int Numero, float PrecioxHora) {

        CanchaTennis canchaTennis=new CanchaTennis(Numero,PrecioxHora);
        CanchaTennis savedCTennis=canchaTennisRepository.save(canchaTennis);
        return savedCTennis;
    }
    @Override
    public List<CanchaTennis> findAll_CTennis(){
        return this.canchaTennisRepository.findAll();
    }
}
