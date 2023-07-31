package com.ucema.proga3.clase.Servicios;

import com.ucema.proga3.clase.Model.Aviso;
import com.ucema.proga3.clase.Model.User;
import com.ucema.proga3.clase.Repositorios.IAvisoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AvisoServiceImpt implements IAvisoService{

    @Autowired
    private IAvisoRepository avisoRepository;

    @Override
    public Aviso createAviso(String texto, User usuario) {

        Aviso Avisoo=new Aviso(texto);
        Avisoo.setUser(usuario);
        //aca hago un set usuario
        //aca se lo agrego a la lista de usuarios
        usuario.CrearAviso(Avisoo);
        Aviso savedAviso=this.avisoRepository.save(Avisoo);
        return savedAviso;

    }
   @Override
   @Transactional
   public Aviso updateAviso(Aviso aviso, String texto){
        aviso.setTexto(texto);
        Aviso updateAviso=this.avisoRepository.save(aviso);
        return updateAviso;
   }
   //Puede ser que este mal:
   @Override
   @Transactional
   public Aviso deleteAviso(Aviso aviso){this.avisoRepository.delete(aviso);
    return aviso;
    }

    @Override
    @Transactional
    public List<Aviso> getAvisoOfUser(){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        List<Aviso> avisos=(List<Aviso>) this.avisoRepository.findByUser_Username(username);
        return avisos;
    }




    @Override
    @Transactional
    public List<Aviso> findBy_Texto(String texto) {
        return avisoRepository.findByTexto(texto);
    }

    @Override
    @Transactional
    public List<Aviso> findAll_Avisos() {
        return (List<Aviso>) avisoRepository.findAll();
    }
}
