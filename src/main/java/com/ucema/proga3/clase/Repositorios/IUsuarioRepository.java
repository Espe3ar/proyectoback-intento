package com.ucema.proga3.clase.Repositorios;

import com.ucema.proga3.clase.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioRepository extends CrudRepository<User,Long> {
    List<User> findAll();
    Optional<User> findByNombre(String name);

    Optional<User> findByUsername(String username);

}
