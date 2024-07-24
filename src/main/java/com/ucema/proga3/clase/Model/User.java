package com.ucema.proga3.clase.Model;

import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "usuario")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    @Column(length = 30)
    private String nombre;
    @Column(length = 30)
    private String Apellido;
    @Column(length = 50)
    private String telefono;


    @Column(length = 100, nullable = false)
    private String username;
    @Column(updatable = true,length = 50)
    private  String Email;

    @Column(length = 100,nullable = false)
    @JsonIgnore
    private String Contrasenia;

    @Column(updatable = true,length = 20)
    private String Categoria;
    @Column(updatable = false,length = 20)
    private  String Genero;
    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Aviso> ListaAviso=new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Reserva> listaReserva=new ArrayList<>();

//Constructores
    public User(){}
    public User(String username, String contrasenia){
        this.username=username;
        this.Contrasenia=contrasenia;

    }
    public User(String nombre, String apellido, String telefono, String email, String contrasenia, String categoria, String genero) {
        this.nombre = nombre;
        this.Apellido = apellido;
        this.telefono = telefono;
        this.Email = email;
        this.Contrasenia = contrasenia;
        this.Categoria = categoria;
        this.Genero = genero;
    }


    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        Contrasenia = contrasenia;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public List<Aviso> getListaAviso() {
        return ListaAviso;
    }

    public void setListaAviso(ArrayList<Aviso> listaAviso) {
        ListaAviso = listaAviso;
    }

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(ArrayList<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }


    public void CrearAviso(Aviso aviso){
        ListaAviso.add(aviso);

    }
    public void deleteAviso(Aviso aviso) {
        this.ListaAviso.remove(aviso);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

   @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
         /* authorities.add(new SimpleGrantedAuthority(role.getName()));*/
        return authorities;
    }
    @Override
    public String getPassword() {
        return Contrasenia;
    }

    public void setPassword(String password) {
        this.Contrasenia = password;
    }
    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}









