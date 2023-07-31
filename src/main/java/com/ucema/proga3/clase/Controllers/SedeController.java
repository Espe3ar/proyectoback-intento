package com.ucema.proga3.clase.Controllers;

import com.ucema.proga3.clase.Model.Sede;
import com.ucema.proga3.clase.Servicios.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ucema.proga3.clase.Model.*;
import java.util.List;
@RestController
@RequestMapping(value = "/api/sede")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SedeController {
    @Autowired
    private ISedeService sedeServicio;
    @PostMapping(path = "/create")
    public Sede createSede(@RequestBody Sede sede){
        return this.sedeServicio.createSede(sede.getNombre(),sede.getDireccion(),sede.getTelefono(),sede.getHorarioApertura(),sede.getHorarioCierre());
    }
    @GetMapping(path = "all")
    public List<Sede> getAllSedes(){return this.sedeServicio.findAll_Sedes();}

}
