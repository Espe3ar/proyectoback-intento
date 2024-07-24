package com.ucema.proga3.clase.Controllers;

import com.ucema.proga3.clase.Model.Cancha;
import com.ucema.proga3.clase.Model.Reserva;
import com.ucema.proga3.clase.Servicios.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ucema.proga3.clase.Model.*;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping(value = "/api/reserva")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservaController {
    @Autowired
    private IReservaService reservaServicio;
    @PostMapping("/create")
    public Reserva createReserva(@RequestBody Reserva reserva){
        return this.reservaServicio.createReserva(reserva.getFechayHoraEntrada(),reserva.getFechayHoraSalida(),reserva.getCanchaReservada());
    }
    @GetMapping(path = "")
    public List<Reserva> getAllReservas(){return this.reservaServicio.findAll_Reservas();}

    @DeleteMapping(path = "/delete/{id}")
    public void deleteReserva(@PathVariable Long id) {
        this.reservaServicio.deleteReserva(id);
    }
}
