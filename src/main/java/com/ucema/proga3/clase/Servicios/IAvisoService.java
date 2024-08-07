package com.ucema.proga3.clase.Servicios;

import com.ucema.proga3.clase.Model.Aviso;
import com.ucema.proga3.clase.Model.User;
import com.ucema.proga3.clase.dto.AvisoDTO;

import java.util.List;

public interface IAvisoService {

    public Aviso createAviso(String texto);
    List<Aviso> findBy_Texto(String texto);
    List<AvisoDTO> findAll_Avisos();
    List<Aviso> getAvisoOfUser();
    public Aviso updateAviso(Aviso aviso, String texto);
    public void deleteAviso(Long id);
}
