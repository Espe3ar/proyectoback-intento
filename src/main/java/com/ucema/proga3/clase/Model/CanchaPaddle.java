package com.ucema.proga3.clase.Model;

import aj.org.objectweb.asm.TypeReference;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("Paddle")
public class CanchaPaddle extends Cancha{

    public CanchaPaddle() {

    }

    public CanchaPaddle(int Numero, float PrecioxHora){
        super(Numero,PrecioxHora);
    }

    @Override
    public float CalcularCostoLuz(){


        return 3000;
    }

}
