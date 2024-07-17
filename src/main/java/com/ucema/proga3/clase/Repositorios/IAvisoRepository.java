package com.ucema.proga3.clase.Repositorios;

import com.ucema.proga3.clase.Model.Aviso;
import com.ucema.proga3.clase.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAvisoRepository extends CrudRepository<Aviso,Long> {

    List<Aviso> findByTexto(String texto);
    List<Aviso> findAll();
    List<Aviso> findByUser_Username(String username);

   // List<Aviso> findAllByOrderByCreatedAtDesc();
    //List<Aviso> findByUserOrderByCreatedAtDesc(User user);



}
