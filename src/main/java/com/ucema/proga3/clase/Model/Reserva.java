package com.ucema.proga3.clase.Model;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id;
    @Column(name = "fyhs_entrada")
    private LocalDateTime FechayHoraEntrada;
    @Column(name = "fyhs_salida")
    private LocalDateTime FechayHoraSalida;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_cancha", nullable = false)
    private Cancha canchareservada;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_usuario", nullable = false)
    private User user;
    public Reserva() {
    }

    public Reserva(LocalDateTime fechayHoraEntrada, LocalDateTime fechayHoraSalida, Cancha canchareservada) {
        this.FechayHoraEntrada = fechayHoraEntrada;
        this.FechayHoraSalida = fechayHoraSalida;
        this.canchareservada = canchareservada;
    }

    public LocalDateTime getFechayHoraSalida() {
        return FechayHoraSalida;
    }

    public void setFechayHoraSalida(LocalDateTime fechayHoraSalida) {
        FechayHoraSalida = fechayHoraSalida;
    }

    public LocalDateTime getFechayHoraEntrada() {
        return FechayHoraEntrada;
    }

    public void setFechayHoraEntrada(LocalDateTime fechayHoraEntrada) {
        FechayHoraEntrada = fechayHoraEntrada;
    }

    public Cancha getCanchareservada() {
        return canchareservada;
    }

    public void setCanchareservada(Cancha canchareservada) {
        this.canchareservada = canchareservada;
    }
    public float CalcularPrecioTotal(){
        Duration duracionReserva= Duration.between(this.getFechayHoraEntrada(),this.getFechayHoraSalida());
        float horasReservadas= duracionReserva.toHours();
        return canchareservada.getPrecioxHora()*horasReservadas+canchareservada.CalcularCostoLuz();

    }



}
