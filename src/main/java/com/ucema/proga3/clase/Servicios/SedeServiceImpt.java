package com.ucema.proga3.clase.Servicios;

import com.ucema.proga3.clase.Model.Sede;
import com.ucema.proga3.clase.Repositorios.ISedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class SedeServiceImpt implements ISedeService{
    @Autowired
    private ISedeRepository sedeRepository;
    @Override
    public Sede createSede(String nombre, String direccion, String telefono, LocalTime horarioApertura, LocalTime horarioCierre) {
        Sede sede=new Sede(nombre,direccion,telefono,horarioApertura,horarioCierre);
        Sede savedSede=this.sedeRepository.save(sede);
        return savedSede;
    }
    @Override
    public List<Sede> findAll_Sedes(){
        return this.sedeRepository.findAll();
    }

}
