package com.ucema.proga3.clase.Model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.ArrayList;

@Entity
@Table(name = "sede")
public class Sede {
    /**
     * Falta crear el metodo consultar disponibilidad
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    private Long id;

    @Column(nullable = false,length = 20)
    private String Nombre;
    @Column(updatable = true, nullable = false, length = 200)
    private String Direccion;
    @Column(updatable = true, nullable = false, length = 200)
    private String Telefono;
    @Column(name = "hs_apertura")
    private LocalTime HorarioApertura;
    @Column(name = "hs_cierre")
    private LocalTime HorarioCierre;
    @OneToMany(mappedBy = "sede",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    private ArrayList<CanchaTennis> ListaCanchasTennis;
    @OneToMany(mappedBy = "sede",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    private ArrayList<CanchaPaddle> ListaCanchasPaddle;


    public Sede() {
    }

    public Sede(String nombre, String direccion, String telefono, LocalTime horarioApertura, LocalTime horarioCierre) {
        this.Nombre = nombre;
        this.Direccion = direccion;
        this.Telefono = telefono;
        this.HorarioApertura = horarioApertura;
        this.HorarioCierre = horarioCierre;
        this.ListaCanchasTennis=new ArrayList<>();
        this.ListaCanchasPaddle=new ArrayList<>();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public LocalTime getHorarioApertura() {
        return HorarioApertura;
    }

    public void setHorarioApertura(LocalTime horarioApertura) {
        HorarioApertura = horarioApertura;
    }

    public LocalTime getHorarioCierre() {
        return HorarioCierre;
    }
    public ArrayList<CanchaPaddle> getListaCanchasPaddle(){
        return ListaCanchasPaddle;
    }
    public ArrayList<CanchaTennis> getListaCanchasTennis(){
        return ListaCanchasTennis;
    }
    public void setHorarioCierre(LocalTime horarioCierre) {
        HorarioCierre = horarioCierre;
    }
    public void AgregarCanchaPaddle(CanchaPaddle cancha){
        this.ListaCanchasPaddle.add(cancha);
    }
    public void AgregarCanchaTennis(CanchaTennis cancha){
        this.ListaCanchasTennis.add(cancha);
    }
    //public boolean ConsultarDisponibilidad(){}


}

