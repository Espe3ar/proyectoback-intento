package com.ucema.proga3.clase.Servicios;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ucema.proga3.clase.Model.CanchaPaddle;
import com.ucema.proga3.clase.Repositorios.ICanchaPaddleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanchaPaddleServiceImpt implements ICanchaPaddleService {
    @Autowired
    private ICanchaPaddleRepository canchaPaddleRepository;
    @Override
    public CanchaPaddle createCanchaPaddle(int Numero, float PrecioxHora) {
        CanchaPaddle canchaPaddle=new CanchaPaddle(Numero,PrecioxHora);
        CanchaPaddle savedCPaddle=canchaPaddleRepository.save(canchaPaddle);
        return savedCPaddle;
    }
    @Override
    public List<CanchaPaddle> findAll_CPaddle(){
        return this.canchaPaddleRepository.findAll();
    }
}
