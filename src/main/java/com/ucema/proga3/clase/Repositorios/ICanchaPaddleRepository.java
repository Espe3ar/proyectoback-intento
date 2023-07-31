package com.ucema.proga3.clase.Repositorios;

import com.ucema.proga3.clase.Model.CanchaPaddle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ICanchaPaddleRepository extends CrudRepository<CanchaPaddle,Long> {
   // CanchaPaddle SaveCanchaPaddle(CanchaPaddle cPaddle);
    public List<CanchaPaddle> findAll();
}
