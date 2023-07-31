package com.ucema.proga3.clase.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("Tennis")
public class CanchaTennis extends Cancha{
    public CanchaTennis() {
    }

    /**
     *Falta hacer el if de que si es de dia no se paga la luz
     *
     */
    public CanchaTennis(int Numero, float PrecioxHora){
        super(Numero,PrecioxHora);
    }

    @Override
    public float CalcularCostoLuz(){
        return 3000;
    }
}
