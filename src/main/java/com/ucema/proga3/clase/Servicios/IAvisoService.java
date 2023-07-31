package com.ucema.proga3.clase.Servicios;

import com.ucema.proga3.clase.Model.Aviso;
import com.ucema.proga3.clase.Model.User;

import java.util.List;

public interface IAvisoService {
    public Aviso createAviso(String texto, User usuario);
    List<Aviso> findBy_Texto(String texto);
    List<Aviso> findAll_Avisos();
    List<Aviso> getAvisoOfUser();
    public Aviso updateAviso(Aviso aviso, String texto);
    public Aviso deleteAviso(Aviso aviso);
}
