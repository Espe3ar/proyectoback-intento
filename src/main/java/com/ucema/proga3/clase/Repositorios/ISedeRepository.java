package com.ucema.proga3.clase.Repositorios;

import com.ucema.proga3.clase.Model.Sede;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface ISedeRepository extends CrudRepository<Sede,Long> {
    //Sede saveSede(Sede sede);
    public List<Sede> findAll();
}
