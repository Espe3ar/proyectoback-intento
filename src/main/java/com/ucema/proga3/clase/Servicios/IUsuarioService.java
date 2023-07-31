package com.ucema.proga3.clase.Servicios;

import com.ucema.proga3.clase.Model.Role;
import com.ucema.proga3.clase.Model.User;

import java.util.List;

public interface IUsuarioService {
    List<User> findAll_Usuarios();
    User findUsuarioBy_Name(String name);

    User createUsuario(User user);
    Role createRole(Role role);
    boolean checkUserById(Long id);
    String authenticate(String username, String password);
    User getUserInfo();
}
