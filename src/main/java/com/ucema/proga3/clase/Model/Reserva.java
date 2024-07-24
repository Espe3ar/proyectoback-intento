package com.ucema.proga3.clase.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id;

    @Column(name = "fyhs_entrada")
    private Date fechayHoraEntrada;

    @Column(name = "fyhs_salida")
    private Date fechayHoraSalida;

    @Column(name = "cancha_reservada")
    private String canchaReservada;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_usuario", nullable = true)
    @JsonIgnore
    private User user;

    public Reserva() {}

    public Reserva(Date fechayHoraEntrada, Date fechayHoraSalida, String canchaReservada) {
        this.fechayHoraEntrada = fechayHoraEntrada;
        this.fechayHoraSalida = fechayHoraSalida;
        this.canchaReservada = canchaReservada;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public Date getFechayHoraEntrada() {
        return fechayHoraEntrada;
    }

    public void setFechayHoraEntrada(Date fechayHoraEntrada) {
        this.fechayHoraEntrada = fechayHoraEntrada;
    }

    public Date getFechayHoraSalida() {
        return fechayHoraSalida;
    }

    public void setFechayHoraSalida(Date fechayHoraSalida) {
        this.fechayHoraSalida = fechayHoraSalida;
    }

    public String getCanchaReservada() {
        return canchaReservada;
    }

    public void setCanchaReservada(String canchaReservada) {
        this.canchaReservada = canchaReservada;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
