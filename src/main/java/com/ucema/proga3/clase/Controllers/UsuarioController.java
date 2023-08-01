package com.ucema.proga3.clase.Controllers;

import com.ucema.proga3.clase.Model.Aviso;
import com.ucema.proga3.clase.Model.User;
import com.ucema.proga3.clase.Servicios.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/usuario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {
    @Autowired
    private IUsuarioService UsuarioServicio;

    @PostMapping(path = "/create")
    public User createUsuario(@RequestBody User user) {
        return this.UsuarioServicio.createUsuario(user);
    }

    @GetMapping(path = "/all")
    public List<User> getAllUsuarios() {
        return this.UsuarioServicio.findAll_Usuarios();
    }

    @GetMapping(path = "/authenticatedinfo")
    public Authentication info() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping(path = "")
    public User getUserInfo() {
        return this.UsuarioServicio.getUserInfo();
    }


}
