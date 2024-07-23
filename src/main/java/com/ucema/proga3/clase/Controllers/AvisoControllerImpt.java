package com.ucema.proga3.clase.Controllers;

import com.ucema.proga3.clase.Model.Aviso;
import com.ucema.proga3.clase.Servicios.AvisoServiceImpt;
import com.ucema.proga3.clase.Servicios.IAvisoService;
import com.ucema.proga3.clase.dto.AvisoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/api/aviso")
@CrossOrigin(origins="*",methods =  {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AvisoControllerImpt {
    @Autowired
    private IAvisoService avisoServicio;

    @GetMapping(path="dame")
    public String hola(){
        return "funciona";
    }
    @GetMapping(path= "")
    public List<Aviso> getAllAvisos(){return this.avisoServicio.findAll_Avisos();}

    @GetMapping(path = "/search")
    public List<Aviso> getAvisoByTexto(@RequestParam String texto){return this.avisoServicio.findBy_Texto(texto); }

    @PostMapping(path = "/create")
    public Aviso createAviso(@RequestParam String textoaviso) {
    return this.avisoServicio.createAviso(textoaviso);
}

    @PutMapping(path = "/update")
    public Aviso updateAviso(@RequestBody Aviso aviso) {
        return this.avisoServicio.updateAviso(aviso, aviso.getTexto());
    }

    @DeleteMapping(path = "/delete")
    public Aviso deleteAviso(@RequestBody Aviso aviso) {
       return this.avisoServicio.deleteAviso(aviso);
    }


    @GetMapping(path="useraviso")
    public List<Aviso> getMyAvisos(){
        return this.avisoServicio.getAvisoOfUser();
    }

}
