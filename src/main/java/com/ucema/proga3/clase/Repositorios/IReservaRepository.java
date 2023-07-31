package com.ucema.proga3.clase.Repositorios;

import com.ucema.proga3.clase.Model.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IReservaRepository extends CrudRepository<Reserva,Long> {
    List<Reserva> findByUser_Nombre(String nombre);
    Optional<Reserva> findById(Long ID);
    List<Reserva> findAll();

}
