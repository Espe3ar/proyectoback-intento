package com.ucema.proga3.clase.Controllers;

import com.ucema.proga3.clase.Model.CanchaPaddle;
import com.ucema.proga3.clase.Servicios.ICanchaPaddleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ucema.proga3.clase.Model.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/canchapaddle")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CanchaPaddleController {
    @Autowired
    private ICanchaPaddleService CPaddleServicio;
    @PostMapping("/create")
    public CanchaPaddle createCanchaPaddle(@RequestBody CanchaPaddle canchapaddle){
        return this.CPaddleServicio.createCanchaPaddle(canchapaddle.getNumero(),canchapaddle.getPrecioxHora());
    }
    @GetMapping(path = "all")
    public List<CanchaPaddle> getAllCanchaPaddle(){return this.CPaddleServicio.findAll_CPaddle();}

}
