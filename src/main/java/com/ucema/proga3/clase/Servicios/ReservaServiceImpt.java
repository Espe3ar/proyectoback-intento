package com.ucema.proga3.clase.Servicios;

import com.ucema.proga3.clase.Model.Cancha;
import com.ucema.proga3.clase.Model.Reserva;
import com.ucema.proga3.clase.Repositorios.IReservaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaServiceImpt implements IReservaService{
    @Autowired
    private IReservaRepository reservaRepository;
    @Override
    public Reserva createReserva(LocalDateTime fechayHoraEntrada, LocalDateTime fechayHoraSalida, Cancha canchareservada) {
        Reserva reserva=new Reserva(fechayHoraEntrada,fechayHoraSalida,canchareservada);
        Reserva savedReserva=this.reservaRepository.save(reserva);
        return savedReserva;
    }
    @Override
    public List<Reserva> findBy_UsuarioName(String nombre){
        return this.reservaRepository.findByUser_Nombre(nombre);
    }
    @Override
    public Reserva findBy_ReservaId(Long id){
        return this.reservaRepository.findById(id).orElse(null);
    }
    @Override
    public List<Reserva> findAll_Reservas(){
     return this.reservaRepository.findAll();
    }

}
