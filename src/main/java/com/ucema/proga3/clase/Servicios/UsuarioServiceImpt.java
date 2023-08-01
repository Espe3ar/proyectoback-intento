package com.ucema.proga3.clase.Servicios;

import com.ucema.proga3.clase.Authentication.JwtUtilities;
import com.ucema.proga3.clase.Model.Role;
import com.ucema.proga3.clase.Model.User;
import com.ucema.proga3.clase.Repositorios.IUsuarioRepository;
import com.ucema.proga3.clase.Repositorios.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpt implements  IUsuarioService{
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtilities jwtUtilities;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager ;

    @Override
    public User createUsuario(User usuario) {
        String contrasenia= usuario.getPassword();
        usuario.setPassword(passwordEncoder.encode(contrasenia));
        String nombre=usuario.getNombre();
        usuario.setNombre(nombre);
        String apellido=usuario.getApellido();
        usuario.setApellido(apellido);
        String categoria=usuario.getCategoria();
        usuario.setCategoria(categoria);
        String genero=usuario.getGenero();
        usuario.setGenero(genero);
        String username=usuario.getUsername();
        usuario.setUsername(username);
        String email=usuario.getEmail();
        usuario.setEmail(email);

        return this.usuarioRepository.save(usuario);

    }
    @Override
    public Role createRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public boolean checkUserById(Long id) {
        return this.usuarioRepository.existsById(id);
    }
    @Override
    public String authenticate(String username, String password) {
        User user = this.usuarioRepository.findByUsername(username).orElse(null);
        if (user == null) { return null; }
        // Generar el token a retornar
        String token = jwtUtilities.generateToken(user.getUsername(), user.getId(), user.getRole().getName());
        return token;

    }
    @Override
    public User getUserInfo() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.usuarioRepository.findByUsername(username).orElse(null);
    }


    @Override
    public List<User> findAll_Usuarios(){
        return this.usuarioRepository.findAll();
    }
    @Override
    public User findUsuarioBy_Name(String name){
        return this.usuarioRepository.findByNombre(name).orElse(null);
    }
}
