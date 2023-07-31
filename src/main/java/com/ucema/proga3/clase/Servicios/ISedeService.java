package com.ucema.proga3.clase.Servicios;

import com.ucema.proga3.clase.Model.Sede;

import java.time.LocalTime;
import java.util.List;

public interface ISedeService {
    public Sede createSede(String nombre, String direccion, String telefono, LocalTime horarioApertura, LocalTime horarioCierre);
    public List<Sede> findAll_Sedes();
}
