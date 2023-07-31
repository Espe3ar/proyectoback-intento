package com.ucema.proga3.clase.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ucema.proga3.clase.Model.*;
import java.util.List;
import com.ucema.proga3.clase.Model.CanchaPaddle;
import com.ucema.proga3.clase.Model.CanchaTennis;
import com.ucema.proga3.clase.Servicios.ICanchaPaddleService;
import com.ucema.proga3.clase.Servicios.ICanchaTennisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/api/canchaTennis")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CanchaTennisController {
    @Autowired
    private ICanchaTennisService CTennisServicio;
    @PostMapping("/create")
    public CanchaTennis createCanchaTennis(@RequestBody CanchaTennis canchaTennis){
        return this.CTennisServicio.createCanchaTennis(canchaTennis.getNumero(),canchaTennis.getPrecioxHora());
    }
    @GetMapping(path = "all")
    public List<CanchaTennis> getAllCanchaTennis(){return this.CTennisServicio.findAll_CTennis();}


}
