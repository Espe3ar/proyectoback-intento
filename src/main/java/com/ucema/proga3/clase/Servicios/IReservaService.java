package com.ucema.proga3.clase.Servicios;

import com.ucema.proga3.clase.Model.Cancha;
import com.ucema.proga3.clase.Model.Reserva;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IReservaService {
    public Reserva createReserva(Date fechayHoraEntrada, Date fechayHoraSalida, String canchareservada);
    List<Reserva> findBy_UsuarioName(String nombre);
    Reserva findBy_ReservaId(Long id);
    List<Reserva> findAll_Reservas();
    void deleteReserva(Long id);
}
