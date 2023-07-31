package com.ucema.proga3.clase.Servicios;

import com.ucema.proga3.clase.Model.Cancha;
import com.ucema.proga3.clase.Model.Reserva;

import java.time.LocalDateTime;
import java.util.List;

public interface IReservaService {
    public Reserva createReserva(LocalDateTime fechayHoraEntrada, LocalDateTime fechayHoraSalida, Cancha canchareservada);
    List<Reserva> findBy_UsuarioName(String nombre);
    Reserva findBy_ReservaId(Long id);
    List<Reserva> findAll_Reservas();
}
