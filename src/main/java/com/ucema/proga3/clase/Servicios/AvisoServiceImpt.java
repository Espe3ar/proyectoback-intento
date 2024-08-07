package com.ucema.proga3.clase.Servicios;

import com.ucema.proga3.clase.Model.Aviso;
import com.ucema.proga3.clase.Model.User;
import com.ucema.proga3.clase.Repositorios.IAvisoRepository;
import com.ucema.proga3.clase.dto.AvisoDTO;
import com.ucema.proga3.clase.dto.UserDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvisoServiceImpt implements IAvisoService{

    @Autowired
    private IAvisoRepository avisoRepository;

    @Autowired
    private UsuarioServiceImpt userService;

     @Override
    @Transactional
    public Aviso createAviso(String texto) {

        User user = userService.getUserInfo();
        Aviso aviso=new Aviso(texto,user);

        return this.avisoRepository.save(aviso);
    }

   @Override
   @Transactional
   public Aviso updateAviso(Aviso aviso, String texto){
        aviso.setTexto(texto);
        Aviso updateAviso=this.avisoRepository.save(aviso);
        return updateAviso;
   }
    @Override
    @Transactional
    public void deleteAviso(Long id) {
        this.avisoRepository.deleteById(id);
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
    public List<AvisoDTO> findAll_Avisos() {
        List<Aviso> avisoList = avisoRepository.findAll();

        List<AvisoDTO> avisoDTOList = new ArrayList<>();


        for (Aviso aviso : avisoList) {
            AvisoDTO dto = new AvisoDTO(aviso.getId(), aviso.getTexto(), new UserDTO(
                    aviso.getUser().getUsername(),
                    aviso.getUser().getNombre(),
                    aviso.getUser().getApellido(),
                    aviso.getUser().getEmail(),
                    aviso.getUser().getTelefono()
            ));
            avisoDTOList.add(dto);
        }

        return avisoDTOList;
    }
}
